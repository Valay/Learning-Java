// Coding Test for Eharmony

Problem Definition:
/******************************************************************************************************************************************************************


Please develop a Java Application that when supplied with a Web URL, downloads all the JPEG images linked on the page using <IMG> tag and produces a file that has the results
from executing the following from within the Java application

1.  Color Histogram Utility written in C++
2.  Image dimension Utility written in Python

The output should be in the following format

Image URL,Local path,Width,Height,Red,Green,Blue 

The source for the C++ and Python utilities can be found attached along with this email.
You are not allowed to modify the Utility code. Your exercise also involves identifying
the required libraries for the getting the two utilities successfully complied and built to be invoked from your Java application.

We expect you to handle standard error conditions such as failures or exceptions in the 
two utilities and reporting the failures in a structured format.

Finally your application should build on a standard linux distribution. Please keep in 
mind the interfaces that you choose to interact with the C++ and Python utilities should be such that your utility could be run on a large cale in a multi-threaded environment.

Sample Output

http://static.eharmony.com/files/corp/images/flip/card-lindsey.jpg,212,172,0.382689,0.329092,0.288220
http://static.eharmony.com/files/corp/images/flip/card-dave.jpg,212,172,0.374687,0.330854,0.294459
http://static.eharmony.com/files/corp/images/flip/card-mark.jpg,212,172,0.353955,0.342315,0.303730
http://static.eharmony.com/files/corp/images/flip/card-tanya.jpg,212,172,0.375128,0.334062,0.290810
http://static.eharmony.com/files/corp/images/flip/card-stephan.jpg,212,172,0.272134,0.359656,0.368211
http://static.eharmony.com/files/corp/images/flip/card-jamille.jpg,212,172,0.388919,0.305373,0.305708
http://static.eharmony.com/files/corp/images/flip/card-laura.jpg,212,172,0.380408,0.358969,0.260623
http://static.eharmony.com/files/corp/images/flip/card-derek.jpg,212,172,0.371585,0.344304,0.284110
http://static.eharmony.com/files/corp/images/flip/card-kyle.jpg,212,172,0.348471,0.356952,0.294577
http://static.eharmony.com/files/corp/images/flip/card-sylvia.jpg,212,172,0.436912,0.318357,0.244731
http://static.eharmony.com/files/corp/images/flip/card-shaun.jpg,212,172,0.335090,0.335945,0.328965
http://static.eharmony.com/files/corp/images/flip/card-cory.jpg,212,172,0.325157,0.321147,0.353696
http://static.eharmony.com/files/corp/images/flip/card-jon.jpg,212,172,0.329399,0.327575,0.343026
http://static.eharmony.com/files/corp/images/flip/card-erin.jpg,212,172,0.347173,0.343231,0.309596

*******************************************************************************************************************************************************************/

/************************  How to run this program  ***************************/

Make sure you have following libraries installed on your computer:
1) CImg library
2) libX11 (CImg depends on it)
3) PIL (Python Image Library)


Go to command line and type following:

$ java -jar downloadimages.jar URL

//replace URL with required URL 

example run

$ java -jar downloadimages.jar http://www.yahoo.com/ 



/******************************************************************************/


Design/Coding Decisions:
/*******************************************************************************************************************************************************************


Library for HTML parsing:
1) Jsoup html parser. (http://jsoup.org/)

Libraries for CPP Utility:
1) CImg libray (I just copied the CImg.h into CPP Utility folder).
2) libX11 (I downloaded it using sudo apt-get installer and it downloaded all its dependencies).

Libraries for Python Utility:
1) PIL (Python Imaging Library, used sudo apt-get installer)


Steps followed in the Program:
````````````````````````````
1) User enters the URL as a command line argument and the program connects the URL and downloads the HTML page.
2) The HTML is parsed to get all the IMG tags.
3) Then the program creates a DIRECTORY to store images. As multiple instance of this program can be ran simultaneously I used timestamp(in milliseconds) as directory name to give unique name to the directory created by each instance of the program.
4) I compile CPP utility and show errors if any of them occurs!
5) After creating the directory I loop over all the images in the Web Page and save only JPEG images.
6) I simultaneously ran CPP and Python Utilities on the images in the same loop.
7) The output is as expected in the problem definition.


Note: I have printed local path also in the output. (as 5th line in the problem definition says that but how ever the Sample Output says something else)
if you dont want it then just comment one line in the java code that displays local directory.
/*********************************************************************
Output looks like this:

Image URL,Local path,Width,Height,Red,Green,Blue 

http://l.yimg.com/cv/ae/us/audience/121017/300x250lweyw4b9v.jpg,/home/valay/Dropbox/Eharmony/Images_2013Mar15_062230_174/300x250lweyw4b9v.jpg,300,250,0.327713,0.329234,0.343053

**********************************************************************/

Platform dependent problem:
``````````````````````````
I have also included compile1.sh script in CPP utility with a minor change in position of "-lX11" and also included "-lpthread" to run on my computer (a standard problem on stack overflow). Platform dependent








