import ij.*;
import ij.process.*;
import ij.plugin.filter.*;
import org.apache.commons.math3.distribution.UniformRealDistribution;





public class ImageStackAugmentation_ implements PlugInFilter {
    ImagePlus imp;
    ImageProcessor ip;

    int imageW, imageH;
    double maxPixel;
    static int FRAMENUMBER = 200;


    public int setup(String arg, ImagePlus imp) {
        this.imp = imp;
        return DOES_16;
    }

    public void run(ImageProcessor ip) {

        this.ip = ip;
        imageW = imp.getWidth();// width of raw image
        imageH = imp.getHeight();// height of raw image
        ImageStack ims = new ImageStack(imageW, imageH);

        int[][] pixels = ip.getIntArray();
        double[][][] weightMap = new double[imageW][imageH][FRAMENUMBER]; //create a weight sequence map
        double[][][] figureStack = new double[imageW][imageH][FRAMENUMBER];//create a figure stack, saved in ims

        double[][] pixelsDoubleNorm = new double[pixels.length][pixels[0].length]; //change int pixels into double type
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if(maxPixel<pixels[i][j]){
                    maxPixel = pixels[i][j];
                }
                pixelsDoubleNorm[i][j] = pixels[i][j];
            }
        }

        for (int i = 0; i < pixelsDoubleNorm.length; i++) { //normalize
            for (int j = 0; j < pixelsDoubleNorm[i].length; j++){
                pixelsDoubleNorm[i][j] /= (maxPixel+1);
            }
        }

        for (int i = 0; i<imageW; i++){
            for(int j = 0; j<imageH; j++){
                UniformRealDistribution distribution= new UniformRealDistribution(pixelsDoubleNorm[i][j]*pixels[i][j], pixels[i][j]+0.1);
                for(int k = 0; k<FRAMENUMBER; k++) {
                    figureStack[i][j][k] = distribution.sample();
//                    figureStack[i][i][k] = weightMap[i][j][k] * pixels[i][j];
                }
            }
        }


        for(int m = 0; m<FRAMENUMBER; m++){
            ImageProcessor ipTemp = ip.createProcessor(imageW, imageH);
            for(int n = 0; n<imageW; n++){
                for(int p = 0; p<imageH; p++){
                    ipTemp.putPixel(n, p, (int)figureStack[n][p][m]);
                }
            }
            ims.addSlice(String.valueOf(m+1), ipTemp);
        }
        ImagePlus imsStack = new ImagePlus("Augmentated Stack", ims);
        imsStack.show();

    }

}