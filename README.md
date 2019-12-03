# Error Tracking Form

**Developers:** Lisa and Miles

Hello ~ This is a project to track errors in a clinical laboratory setting. Errors occur in the laboratory. In order to fix chronic issues, there must be a way to track variances. This is a cornerstone of the LEAN philosophy that is followed in many accredited laboratories. This program serves as a way to digitally store, search, and create error tracking forms.

The super class QC form will have the hospital information and QC filing information. This also could be in interface.

The subclass, Variance Report will have the questions that are on the form (with command line interface for answers), in addition to get and set methods.

The driver class will have the search function, and ability to make a new form.

An exception class will be included that will throw an error if a file cannot be accessed.

A QC file handling class will allow us to read and write to the file system and maintain the Array list of QC forms. (I/O stream). Not sure how to categorize this class.. maybe should be abstract of interface.

I don't feel really comfortable with the I/O stream functions (we just learned them last week). I'm also unclear on how the arraylist/array will be generated (and in which class).
