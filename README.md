# 157aProject

Project Overview:
The goal of this project is to use JDBC to create a Books database, populate it, and then execute different SQL statements to query or manipulate the Books database.

authors authorID
firstName lastName
authorISBN
authorID isbn
titles
isbn
editionNumber copyright publisherID
price
publishers publisherID publisherName


Overview:
In this project, using JDBC application that access the Oracle RDBMS in the design center (you need to have an account), you will need to:
• Create the Books database tables as specified in the schema definition
below.
• Initialize the different tables (at least 15 entries per table) appropriately: all
fields cannot be null.
• Issue the following SQL statements. For queries print the results from java
into your console:
• Select all authors from the authors table. Order the information
alphabetically by the author’s last name and first name.
• Select all publishers from the publishers table.
• Select a specific publisher and list all books published by that
publisher. Include the title, year and ISBN number. Order the information alphabetically by title.
• Add new author • Edit/Update the existing information about an author • Add a new title for an author • Add new publisher • Edit/Update the existing information about a publisher

Schema Definition:
1. authors Table:
Field SQL Type Java Type Description
authorID INTEGER integer This is an autoincremented field. For each new rec-ord inserted in this table, the database automatically increments the authorID value to ensure that each record has a unique authorID. This field is the pri-
mary key for this table.firstName CHAR(20) String Author’s first name.lastName CHAR(20) String Author’s last name.

2. authorISBN Table:
Field SQL Type Java Type Description
authorID INTEGER integer The integer ID in this field must appear also in the
authors table
isbn CHAR(10) String The ISBN number for a book

3. titles Table:
Field SQL Type Java Type Descriptionisbn CHAR(10) String ISBN number of the book
title VARCHAR2(500) String Title of the bookeditionNumber INTEGER integer Edition number of the bookcopyright CHAR(4) String Copyright year of the bookpublisherID INTEGER integer Publisher’s ID number. This value corresponds to an
ID number in the publishers table.price NUMBER(8,-2) float Suggested retail price of the book

4. publishers Table:
Field SQL Type Java Type Description
publisherID INTEGER integer Publisher’s ID number. This autoincremented inte-
ger is the table’s primary-key field.
publisher-Name
CHAR(100) String The name of the publisher.


