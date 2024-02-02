<h3>Hotel Rating System Project by using Microservices Architechture</h3>
<p> In this project I have developed a Hotel Rating System in which the User(client) can get information about different hotels. User can see the feedbacks given by other users for any hotel and can also post, update or delete his/her previous feedback. I have used microservice architecture and have created all the services as microservice which are interacting with each other with the help of REST APIs.</p>
<br>
<h3> Backend Working Process</h3>
<p>There are three main microservices in this system:</p>
<ul style="list-style-type:circle;">
  <li>User Service</li>
  <li>Rating Service</li>
  <li>Hotel Service</li>
</ul>
<p><b>User Service</b>: This is handles the user database which contains information of different users. It is the service which is actually interacting with the client's requests via an API Gateway. It recieves the request from client and accordingly fetch the data from rating service and hotel service to send the response.</p>
<p><b>Rating Service</b>: This service handles the rating database which contains all the ratings of different hotels given by different users. It recieves the request from User service or directly from API Gateway and request Hotel service to get data for sending the response.</p>
<p><b>Hotel Service</b>: This service handles the hotel database which contains information about different hotels. This microservice recieves request from Rating Service.</p>
<p>Apart from these three entities, this project have some microservices which are required for configuration and efficient working of system:</p>
<ul style="list-style-type:circle;">
  <li>API Gateway</li>
  <li>Config Server</li>
  <li>Service Registry</li>
</ul>
<p><b>API Gateway</b>: This microservice establishes a gateway between the entities and client. It recieves the request from client and then accordingly request data from different services. It reduces the client's effort of typing different URLs for different services from different microservices. Now client can use all the services by simply calling to API Gateway. </p>
<p><b>Config Sever</b>: This microservice consist data for configuration for each microservice i.e. it configures all the microservices in the system.</p>
<p><b>Service Registry</b>: This microservice creates a server for our system. It registers all the microservices, hence making this system independent of the local machine. Moreover, one can monitor all the microservices i.e. its status, health etc. through this server.</p>
