
				Scalable Request 
	
  Problem with Single machine
	1. Parallel Request. 
	2. Geo location. If user are distributed in across. Network latency
	3. Data size limitation. Again single machine topology. That is limitation for single machine
	4. Single Point of Failure. If your machine is down your app is down.
	5. Server hotspot. If all request goes to single machine. Then Server become hotspot
	6. Data hot spot may also occur. If single attribute or records. 
	   Read hot spot : If millions of user trying to read the same data at same time.
	   Write hot spot : If millions of user trying to write the same at the same time.
	   
	   
  BuildingBlocks To Solve this problem :
  
  1. Set of app server behind load server.
     
      In this topology. LoadServer is distributing the load to multiple machine
      behind it.
   
   2. This solves the problem of Server Hot Spot issue. Load is divide to multiple machine
   
   3) Solves the single point of failure. If machines goes down traffic diverted to other machine.
   

Data Replication Machine : Data is copied to multiple servers. Which are in the network
 Node A <---->Node B 
    \         /
      NodeB
      
      All three nodes are in sync data is getting replicated. Solves data hot spot.
      
Difference between data Data Shradding and Data Replication >

1) Replication is entire data.
2) Shradin or partition . Sharding of row to multiple servers.
  Partition or shardnig is same. 
  Sharding is howirzontal row partition.
  Each sharding is hosted to each servers.
  Shard A to one server and Shard A to anothe server.
  
  What problems sharding  solves data size limitation issues. As data goes larger
  size what your hard disk hold data.
  It solves you parallel request issue. If request is evenly distributed
  it may be possible request is distributed evenly. Shrading will help only if you have 
  multiple cells
  
  
  
  Caching : At the application layer independent block.
  1. If will help in Read hotpsot. Build multiple cache. Mitigate read hotspot
  2. Mitigate parallel read request.
  3. Mitigate GEO location issues
  
  
  Micro Services Pattern: 
  1) What is micro services : Micro services collection of loosely coupled services.
  2) Derivative services oriented architecture.
  
  Keep loosely coupled. Scale as app usage and data usage.
  1) You have app tier. 
  Login API --> Component
  API , Cache, Storage
  
  Interaction ---> App  --writing into--> DataStorage 
                   App ---> Writing and Reading data from cache.
                    -----> Writing data from cache to Storage
                    App can talk to another APP.
                    Any changes happening to external system using pub sub model. (Publish)
                    Cache can be updayed based on the events happenging outside (Subscribe)
                    

Storage Layer:
1. Storage building block can be used

a) Relational RDBMS
b) KVP model : Key value pair model. No sql goes with this approach. Key is primary 
   uniquely identify. Value is again key value.
 JSON object like document data. Or serailized data. Or represents cell.
                   
  Values ---> 1) KVP's
              2) XML /JSON
              3) Values could be blobs
              4) Graph model ---> Social graph.
    What ever model we choose. We can represent the data as column and row.
    
2. Physical Schema : 
    
    a) Row major format 
    b) Column major format
      
    In row format the data exist on disk every thing is offset.
    1) offset 001 the data starts for first row and offset 002 will have second row.
    Traditional RDBMS stored the data as rows with offset. If you want to fetch 
    specific column you need to seek entire row or scan that row. This 
    heavy read operation.
    
    Row format is not condusive for doing Max average of columns.
    
    Column Major Format :
    
    Column family : UserId, Name,email,
    Row:            col1   ,col2, col3
    
    Like smaller set of column and value is stored in the disk.
    Supported by cassandra and Reddis
    
    Used to define seperate columns for Max and Minimum for average, sum, mean to define
    for the 
    
3. INDEXING
Indexing help you to fetch the data in much faster way.

1. Key and Value
What is hashIndex Map. Basically it contains the hashKey and offset.
IT contains key and Offset. It's seperate file as hashIndex table on disk.

Key : offset
001    0
002    512

Primary Key are mostly is hash Index.
Ebvery time there is reterival of data on primary key. Exactly match.
Mostly 99.9. All Primary key are matched with HAshIndex. It contains hash Value 
as key of primary key. And value as offset.
User Id, Value (It can be key value pair again)
001
  
Every time you access the data for given user. You will be provided user ID
based on user ID there will be hash. Give location in the Index table get the offset.
USe offset to get the data from the Main table.

Another Type Of Index is B Tree Index


Combination we can define as hashIndex
Eample: Reterival based on name and location
Location as = "US"
NAME is list of name [, , , ]

We can have B Tree Indexes based on loacation
location=US and one for location=EU
With in each bucket we have 


Question 1
When to use HAshIndex : When you have exact match? Choose HashIndex.

When to use B Tree Index: Not exact match. Range based reterival.

When to use Combination of Index: Parts of exact match and part of it is not.
If you have a small finite match of data
With in this you have more data. Then it is possible to find the match of B Tree iondexes.


Sharading Concepts : General. Horizaontal partitioning. In rows
Goals of Sharding : Most of the data base supports provides the flexiblity.
Split data into set of rows. 
Say SHRED A (OF two rows)
Say SRHRED B (Of Two rows)

Goals of shredding.
1) New even distribution of data
2) Add new shards
3) Shards are not available. If that node is down.

Simplistic approach of Shredding
1. Fixed n sharads.
2. UserId % n (Remainder will be shreds) USer will go to Shreds.

Problem with simplistic approach.
1) You may get even distribution.
2) Now whe you add a new shreds. Adding new shreds become very expensive.
Now we need to move data physically to new Shreds.It's very expensive.
System may down.
3) Shreds are not available.Data can not be served.

Other solution for Shredding. One industry standad that using consisting hasging algorithm
Consisting hasging solves lot of problems:

Consistent HAshing: Range is fixed ( 0 to n-1). n is not a number of shreds.

Question : 
1) Whether you need shrading or not.


How data replication happens:
 Challenge : Data should remain consistent.
 Concept : Eventual consistency,All the data will be consistent.
 
 Let's assume there are three replicas
 
 Say replica A and B and C.
 
 
 Consistency and availablity at the application layer.
 
 CAP Theoem :(Consistency, Availblity, Replication)
 
 From database point of view it is consistent but from application level
 it is not consistent. When write is happen to one of the node and the red happen
 to other node.Data still not replicated from node one to node two.
 From database point of view it is eventual consistency will happen.
 
 For Applicatiop layer point of view there are two models.
 
 
 1) Available model -->  For available mode consistency is not gurantee.
     In available model consistency is not gurantee.
     In available model you don't fail request easily.
    a) Less failure.
    b) Stale reads. Data is not replicated to all nodes. From application point of view it's
        not consistent.
    Write and read done against different nodes and replicated data in all nodes after some time.
    So in available model consistency is not gurantee.
    
2) Consistent model : Data need to be consistent in the application layer.

    Quoram will be handle at database level.
    ---> Quoram reads. Reads from majority of node. Depending of data with time stamp it will get the 
    latest change.Application will read as consistent data.
    ---> Quoram writes: It will write in majority of nodes.
    
    --Downside of Quoram is availablity is not achivable. Chanses are there multiple nodes are down.
       Availablity is not rechable. It needs majority of replicas are rechable for read.
       IT has to fail the request whether it is read replica or write replica.
    
    Quoram reads and write gurantee for consistency but availblity is not gurantee.
    
    For consistent model you should have
    R + W (No nodes)> Replicas
    
    Concept of CAP : (Consistency + Availablity + PArtition)
    
3) Partition tolerance : In distributes P is given we need to choose FOR C and A.

CACHING : Is fairly general term.

Designing cache : Typicaly it is key valuer pair. We need to design it.

1.)  what is stored.
2. ) Cache can be seperate as as service. Or we can embed to each node.
3) Size
4) Decide also type of cache.
5) Physical tiopology.
    







              
   
  
  
  
  
  
  
      

	