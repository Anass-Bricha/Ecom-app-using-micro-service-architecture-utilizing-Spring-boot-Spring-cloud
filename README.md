# Ecom App To demonstrate micro-service architecture + Security with Keycloak + Front with Angular

## Keycloak 20.0.2
* Command to start **keycloak** in the memory database (For windows): **kc.sh start-dev --storage=chm**
* Command to start **Consul**:  consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=your-ip-address

## Serivces
### > Configuration service :
#### > To initiate the configuration service, we need these depensencies :
![image](https://user-images.githubusercontent.com/79362593/208492256-dce92526-18aa-437b-8fe1-e06bb713991a.png)
* After, we need to create a local or repository, and create our confiuration files, then commit them to the repository
![image](https://user-images.githubusercontent.com/79362593/208492463-5a45990a-8776-46e9-85c4-80c6f8b2297e.png)
* To activate any new updates made to any configuration, we need first to commit the changes, then send a post request to : http://localhsot:port/actuator/refresh to activate them.

### > Gateway service : 
#### > To initiate the gateway service, we need the depensencies : 
![image](https://user-images.githubusercontent.com/79362593/208492950-a2c9443d-d1c9-4302-bb82-c0a93eee8538.png)
* Then, add the properties in application.yaml to configure the service and import the configuration for the configuration service : 
![image](https://user-images.githubusercontent.com/79362593/208493129-9d426290-5d0b-4433-b9ec-9625a602d1b3.png)

### > Registration service : 
* We are using **Consul** as our registration service, to work with Consul, just download the Zip file from https://developer.hashicorp.com/consul/downloads?host=www.consul.io
* Then open the correspond folder in Terminal, and execute the command mentioned above.
![image](https://user-images.githubusercontent.com/79362593/208493792-38bd8e6a-3a6b-43b6-bbde-ac5c81889017.png)

## Security
### > Security Configuration :
## NOTE : we added security to one service (Customer service) just for demonstration
#### > Before we start configuring keycloak, we need first the dependencies : 
![image](https://user-images.githubusercontent.com/79362593/208494329-51cda1a2-dbc8-4950-b022-a5386242442d.png)

