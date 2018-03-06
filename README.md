
# Short description
[![Version](https://img.shields.io/badge/version-1.0.0-green.svg)]()

A downloader with the aim of studying it.


# Server options:

Paquer: It's the class that gives the methods for put the code into images.
GraficPaquer: That class gives a basic GUI for the class paquer.

# Target options:

Unpaquer: This class gives the methods for get the code of the images and run it.
DownloadCode: This class gives the methods for downloading code and uploading it. The class downloads the image and call the Unpaquer methods.

# How works the server:

You need to run a web server for putting some images, you need to put this in the web server.
·A "index.html" file , in it, ONLY put the name of the images, with no html tags.

·A file named "version" with a version number.

·An image with the code.

# How works the client:

A little mods that you need change in the code before run it:

In the Unpaquer file: Change "DireccionAlmacenamiento" (in lines 50 and 54) for a local direction.

In the DowloadCode file: Change "DireccinWeb" for the URL of your server.
