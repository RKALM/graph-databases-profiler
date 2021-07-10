# A Performance Comparison between Graph Databases
### Degree Project Plan about the comparison between Neo4j, GraphDB and OrientDB on different operations
 
- Alm Robert 
- Imeri Lavdim

## Problem definition
The aim is to compare different NoSQL graph databases in terms of complexity and performance. The Databases that will be investigated are Neo4j, GraphDB and OrientDB, three graph databases that use a graph structure to store their data. The project also aims to draw conclusions about in which case each of the Databases performs better and why.

## Motivation
As the global computational needs are increasing, traditional Databases, for example Relational Databases, struggle to cope with the technological advancement of human society, and that highlights the need for new solutions that can improve, not only the speed, but also the robustness and the flexibility of a database. As it is stated in "A Comparison of Current Graph Database Models" by Renzo Angles:

> "The limitations of traditional databases, in particular the
> relational model, to cover the requirements of current applications
> has led the development of new database technologies. Among them, the
> Graph Databases are calling the attention of the database community
> because in trendy projects where a database is needed, the extraction
> of worthy information relies on processing the graph-like structure of
> the data."

NoSQL Databases are competing against the traditional Databases for at least a decade now, and this continuing innovation brought forward a new kind of NoSQL Databases, namely the Graph Databases. Graph Databases are promising due to their ability to use Graph Algorithms to their advantage, and for their ability to make connections between their data, a thing that is, for example, extremely important for Artificial Intelligence.
Graph Databases are Databases that are based to Graph Structures, and likewise the typical Graph Data Structures, Graph Databases consist as well of Nodes, Edges and Attributes, (that store data inside the Nodes and the Edges). While Graph Databases are considered of type NoSQL, they have an element that makes them very different from the regular NoSQL Databases which is the existence of relations. Relations in Graph Databases are represented as Edges and they stored and used as such. This characteristic

makes them more efficient for relation-based queries and the graph structure gives the opportunity to Graph Databases to be traversed with the support of the existent Graph Algorithms, thing that makes them competitive against other types of databases, (especially the ones that are not designed to handle relations).
As different Graph Databases gather to compete with the other Databases and the other Graph Databases, it gets increasingly important to know which Graph Database utilize Graph Algorithms in the best way possible, and how we can use each of them in an optimal way.

The idea is about a qualitative comparison between Neo4j, GraphDB and OrientDB with a final goal to draw a conclusion on which of those three Databases is suitable for each different CRUD, (Create Read, Update, Delete), operation. Research literature will be used in a large scale, as the best source of information now is the existent documentation for each database, and there is the desire to use profiling as well to compare, (in a smaller scale), the performance of each Database on CRUD operations for each of the selected databases. The specific three databases were selected because of their popularity and because they are compatible with Java which we intent to use for profiling.

The authors, (R. Alm and L. Imeri), had both enough experience with different Databases during their studies in this programme, and we wish to consider analysing each of the three Graph Databases with the goal to classify the different characteristics of each Database, and how each of them can be used properly.

Source of Inspiration for this Idea are the books, “Databases Illuminated” and “Data Structures and Algorithmic Analysis in Java”, and it is expected that other publications about the topic will be used, as the complexity of the topic requires deep and variant research literature. The special technical characteristics of the many known Databases are highlighting the need for the use of a technical documentation for each of the selected databases, which can be found in the official web pages of each Database.

## Research Questions
1. What is the complexity on CRUD operations of Neo4j, GraphDB and OrientDB Databases.
2. How do Neo4j, GraphDB and OrientDB perform on their CRUD operations in terms of time.
3. How complexity can affect the performance of Neo4j, GraphDB and OrientDB. Why do those 3 Databases act that way.

## Methodology

### Literature Review (for the research questions 1 and 3)
The basic component to understand each Database it is its own documentation and the work that have been done before by others to categorize the various technical characteristics, so before any analysis or any profiling takes place, it is essential to review and to study the literature that exists about the performance, the complexity, and the technical characteristics of each database with focus to the documentation that is provided by the official sources of each Database.


### Profiling, (for the research question 2)
To answer the second research question, experimental methodology is necessary. The method that will be followed will be an experimental method which is called profiling which is the process of counting the time which is necessary to complete a specific task.
For our experiment, the specific task will be the four operations of CRUD upon the least common unit of operation between the three Graph Databases which is a node. With consideration that all the Databases in question are Graph Databases, a node is selected as it is the very basic element of their data structure and it plays the very same role that an entry or a row, (for a relational database), for one other database.

As we wish to have an idea about the performance of each Database, profiling becomes necessary. To achieve an objective and well-constructed profiling, few rules will have to take place.
1. All three of the Databases will have to be profiled locally and in the same computer and in the same conditions.
2. All the tested Database will have to be accessed by their most recommended DBMS to exclude cases that are too simplistic or primitive, (for example the access through a simple file or variable).
3. All Databases that must be tested should be compatible with Java because we intend to use Java for profiling.
4. All the CRUD operations will be tested separately by having the node as a common unit of operation. CREATE will mean to create a node with a specific content, for each unit, READ will mean to read the content of a node for each unit, UPDATE will mean to edit a specific element inside a node for each unit and DELETE will mean to delete a node for each unit.
5. The units are used to increase or to decrease the scale of the experiment, and it indicates how many nodes will be used for each operation. For example, if the scale is 1000 units for the operation CREATE, 1000 nodes will be created with the same content, (their id of course will be unique and different), for each of the three Graph Databases. Same process of course will be followed for the other operations as well.
6. For all the operations the timer for the profiling will start exactly when the number of specific operations will be requested from a Java terminal and it will stop when the number of operations will be complete.
7. Same process will be followed for all of four operations and all three Graph Databases and for different sets of units but it has to be a different profiling session for each case. That means for four CRUD operations on three Graph Databases and, (for example), 5 different scales, (sets of units, multiplies of 10), 4x3x5=60 different profiling sessions will take place.

### Analysis, (for the research questions 1, 2 and 3)
After completing the Literature Review and the Profiling, we can use the received data and to start drawing conclusions.
We will take the data which is fetched from the profiling and we will identify where each Graph Database performed better or worse from the other databases and we will try to map the performance differences to the structure and the logical workflow of each Graph Database.
First, the logical workflow of each Database will be theoretically analysed to recognize its strong and week points. The very next step will be to compare the theoretical analysis with the profiling data to see if the profiling corresponds the theoretical benefits and drawbacks of each Database and why.

## Expected Results
The expected data will be displayed, (in two-dimensional diagrams), indicating how well each Database performs in each different profiling session, and together with the analysis from the Literature Review will be able to highlight the strong and the week points in the workflow of each Graph Database and other possible strengths or limitations.
