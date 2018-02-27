
# Short description

A downloader with the function of studying.


# Server options:

Paquer: Is the class that give the methods for put the code in images.
GraficPaquer: That class give a basic GUI for the class paquer.

# Target options:

Unpaquer: This class give the methods for get the code of the images and run it.
DownloadCode: This class give the methods for downlaod code and upload it. The class download the image and call the Unpaquer methods.

# How works the server:

You need run a web server for put some images, you need put this in the web server<.
·A "index.html" file , in it, ONLY put the name of the images, with no html tags.

·A file named "version" with a version number.

·An image with the code.

# How works the client:

A little mods that you need change in the code before run it:

In the Unpaquer file: Change "DireccionAlmacenamiento" (in lines 50 and 54) for a local direction.

In the DowloadCode file: Change "DireccinWeb" for the URL of your server.
