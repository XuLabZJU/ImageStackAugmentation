# ImageStackAugmentation
Augmented SRRF (aSRRF) pushing the limits of SIM, utilizing a synthetic stack for SRRF reconstruction.

# System requirements
ImageStackAugmentation_.jar will require a running installation of Fiji/ImageJ.

Full instruction for the installation of Fiji can be found at: https://imagej.nih.gov/ij/download.html

Tested on windows 10x86, macOS monterey 12.6. All the tests of this plugin were implemented on FIji 1.53. (ImageJ version number can be found under: Help -> About ImageJ...)

Matlab script were developped using 64bits Matlab R2021b, containing imapcts of various distribution functions for aSRRF.

# How to install plugin 
Prior to ImageStackAugmentation_.jar installation, the latest version of FIJI must be running on your computer (https://fiji.sc/). Moreover, SRRF (<https://github.com/HenriquesLab/NanoJ-SRRF>) plugin should also be installed. Moreover, if the SRRF plugin crashed while running at windows, you may install OpenCL at microsoft store library.

To install this plugin manually in Fiji:
+ Download the latested version of this plugin.
+ Copy ImageStackAugmentation_.jar file to your specific Fiji Plugins installation directory folder.
+ Restart Fiji.

# Instructuons for use
- Open ImageJ.
- Open the test image TIRFTestImage.tif or SIMTestImage.tif. You can also use your own data (16-bits). 
- Go to Plugins -> ImageStackAugmentation.(Choose the frame number and the fluctuation method.)
- Go to Plugins -> NanoJ-SRRF -> SRRF Analysis. A window will open.
- Define the parameters, and additional features.
- Click on "OK" button.

After a few seconds (depending on the specifications of your computer, the defined parameters and the data to be analyzed it might take longer), a super-resolution image will appear.

![SIM aSRRF](https://cdn.jsdelivr.net/gh/lukezhangh/PictureBed/img/202212181836796.png)

![nano rulers](https://cdn.jsdelivr.net/gh/lukezhangh/PictureBed/img/202304100854649.png)
