# Ecom App To demonstrate micro-service architecture + Security with Keycloak + Front with Angular

## Keycloak 20.0.2
* Command to start **keycloak** in the memory database (For windows): **kc.sh start-dev --storage=chm**
* Command to start **Consul**: 

## Serivces
### Configuration service
#### > To initiate the configuration service, we need these depensencies :
![image](https://user-images.githubusercontent.com/79362593/208492256-dce92526-18aa-437b-8fe1-e06bb713991a.png)
* After, we need to create a local or repository, and create our confiuration files, then commit them to the repository
![image](https://user-images.githubusercontent.com/79362593/208492463-5a45990a-8776-46e9-85c4-80c6f8b2297e.png)
* To activate any new updates made to any configuration, we need first to commit the changes, then send a post request to : http://localhsot:port/actuator/refresh to activate them.
