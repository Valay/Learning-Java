# 
# Assume one parameter.  A file name that may be relative or absolute.
#
import sys
from PIL import Image     # PIL library: http://www.pythonware.com/products/pil/
image_file = sys.argv[1]
img = Image.open(image_file)
width, height = img.size
print ('(' + str(width) + ', ' + str(height) + ')')
