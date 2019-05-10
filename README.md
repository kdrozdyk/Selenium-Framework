Seleinum-Framework created by Konrad Drozdyk in purpose of minimalizing the brittleness of selenium,
while also making it more structured leading to higher maintainability and readability. 

As of now the framework consists of: 

-Page Object Model based class BasePageModel. It should later be inherited
by your page objects. It is an abstract class, with the sole purpose of creating a structure for 
your page objects. In order to be more secure to change from the Selenium API, all of the communitacion
with Selenium should be made within this class, which makes it easier to maintain. 

-Base Test Model that is also a structural class that should be inherited by other test classes.
This structure makes the tests more readable, sets up and tears down your tests, and can be used to 
set the settings for your tests. 

-Driver Manager Factory is a class that makes it easier to set up your tests according to the browser
of your choice. While creating settings for your tests in base test model you should use the enum created
in this class in order to easy choose your browser.

This is a project that will keep involving and as of now is very basic. Keep in mind that there are 
other frameworks available that can be better fit for your project. 