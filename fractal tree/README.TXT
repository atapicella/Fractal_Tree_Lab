Introduction

The goal of this lab is to create a recursive algorithm to draw a tree.

Imagine you were describing how to draw a tree. You might say:

* Draw a vertical line
* At the top of the line, draw two smaller lines ("branches") in a v shape
* At the ends of each of those two branches, draw two even smaller branches
* Keep repeating the process, drawing smaller and smaller branches until the
	branches are too small to draw

This process of repeating the same design at a continually decreasing scale
	is an example of a Fractal. Using fractals to draw trees can give some
	interesting and beautiful patterns. In this assignment we will use a
	recursive branching function to create a fractal tree.

Requirements

* Use the Koch Snowflake program as a starting point for an TreeViewer class
	and a TreeComponent class.
* The trunk of the tree needs four values: the X and Y of the starting point
	and the X and Y of the end point. We will also have three member
	variables that will control:
    * how much smaller the branches are
    * how small the branches will get
    * the angle between the branches.


Submission:

* Submit a pull request in GitHub and submit a link to the request with this
	assignment.


Extensions:

* Add controls (e.g., scrollbars) to allow the user to change member
	variables that affect the construction of the tree.
* Some fantastic trees can be produced by modify algorithm to add asymmetry,
	adjust angles,  adjust thickness, or adjust color.
* Add more awesome.