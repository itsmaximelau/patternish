## Description
<b> patternish </b> is a random pattern generator made with Java. Patterns are generated from random polygons and makes perfect abstract backgrounds.

## How does it work ?
A pattern is generated from a base image.The menu on the right basically allows you to change the base image. Then, a transformation is applied to the base image to rotate or flip it and the transformed image is copied to the right of the base image. Then another transformed image is copied next to the previous one and the same process is done to fill the full image, from left to right, top to bottom. So the interesting part is that we need to generate a base image that we like and then apply a transformation that then makes it interesting as a complete image. 

## Parameters and features
* Shapes
  * Amount : Amount of shapes per base image.
  * Minimum and maximum vertices : Amount of vertices are randomly determined for each shapes, between minimum and maximum. 
  * Border size : Size of the outline of the shape.
  
* Colors
  * Background : Background color for the base image.
  * Shape colors 1 to 3 : Possible shape colors for the base image.

* Base image dimensions : Size of the base image. The larger the X and Y are, the less repetitions there are.

* Export image dimensions : Size of the image that will be exported.

* Rotation/Transformation : Choose between different types to set a transformation that will be applied to the base image to generate the full image. Random type randomly set one of the available transformations.

To export an image once it's generated, click on Action in the menu and then Export. You will then be prompted to choose where you want to save the image.

## Example
![Usage example](https://github.com/itsmaximelau/patternish/blob/master/resources/exampleGif.gif?raw=true)

## Setup
Just make sure Java is installed and then, run the JAR file named patternish.jar which is located at the root of the project.

## What have I learned with this project ?
- Java (first solo Java project).
- Swing GUI (I really tried to make it look good, my first Java group project GUI didn't look that good).

## To do (features that could be added in the future)
- Add more shapes (ellipses, for example).
- Add the possibility to choose more than 3 colors.
- Add the possibility to choose borders color.
- Add more transformations.


## Issues (to fix)
- None known at the moment.
