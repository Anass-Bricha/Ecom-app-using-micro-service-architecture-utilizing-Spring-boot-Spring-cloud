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
We are using to secure our app keycloak adapter.
## NOTE : we added security to one service (Customer service) just for demonstration

### > Security Configuration :
#### > Keycloak configuration : 
* To launch keycloak locally, after downloading the zip file, you need to open the bin folder inside the keycloak folder, then launch the command above to start keycloak using **memory storage**.
* After launching, open keycloak on http://localhost:8080
![image](https://user-images.githubusercontent.com/79362593/208495822-88126d6c-9e33-4e85-8c69-f3e5f7730376.png)
![image](https://user-images.githubusercontent.com/79362593/208495974-8c48391a-1fe7-4d46-b01e-0eeb1911bf6e.png)


#### > Before we start configuring keycloak on spring boot, we need first the dependencies : 
![image](https://user-images.githubusercontent.com/79362593/208494329-51cda1a2-dbc8-4950-b022-a5386242442d.png)
* And we need to add keycloak adapter : 
![image](https://user-images.githubusercontent.com/79362593/208494428-f0a8046a-2d0c-44c4-af24-1f1d506cc8ae.png)

#### >Keycloak adapter configuration
* Keycloak uses keycloakAuthenticationProvider that implements AuthenticationProvider
![image](https://user-images.githubusercontent.com/79362593/208494809-9f32a129-59ee-465a-abbb-d1eeb85bc591.png)
### Keycloak uses a configuration file **keycloak.json** , and to use application properties to set keycloak configuration properties, we need to add the following Bean :
![image](https://user-images.githubusercontent.com/79362593/208495334-2db551a0-c227-4bf1-b748-621f6da9e77b.png)


