# Bus

- Create an abstract Bus with ID, capacity and cost. 
- Create an interface LiquidFuel which contains emissionTier, consumption and fillWithFuel.
    - Remember you can't set instance attributes/variables inside of an interface!
- Create an interface ElectricFuel which contains voltage, consumption and recharge.
    - Remember you can't set instance attributes/variables inside of an interface!
- Create 3 different Bus classes, one entirely electric, one with only liquid fuel and one hybrid.
- Create a ServiceStation which only has one method that can fill up any bus it is given. Use polymorphism for this.
    - Filling up an electric bus will return: "Recharging my batteries!"
    - Filling up a liquid fuel bus will return: "Filling up my tank!"
    - Filling up a hybrid bus will return: "Filling up my small tank! Filling up my small batteries!"