package pl.edu.wszib.car.rent.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.authorization.AuthenticatorV2;
import pl.edu.wszib.car.rent.authorization.IAuthenticator;
import pl.edu.wszib.car.rent.core.ICore;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.VehicleRepository;
import pl.edu.wszib.car.rent.gui.GUI;
import pl.edu.wszib.car.rent.gui.IGUI;

@Component
public class Core implements ICore {
    private final IVehicleRepository vehicleRepository;
    private final IAuthenticator authenticator;
    private final IGUI gui;

    public Core(IVehicleRepository vehicleRepository,
                IAuthenticator authenticator,
                IGUI gui) {
        this.vehicleRepository = vehicleRepository;
        this.authenticator = authenticator;
        this.gui = gui;
    }

    @Override
    public void start() {
        boolean run = false;
        int counter = 0;

        while(!run && counter < 3) {
            authenticator.authenticate(gui.readAuthData());
            run = authenticator.getLoggedUser() != null;
            counter++;
        }

        while(run) {
            switch(gui.showMenuAndReadChoose()) {
                case "1":
                    gui.listVehicles();
                    break;
                case "2":
                    gui.showResult(vehicleRepository.rent(gui.readPlate()));
                    break;
                case "3":
                    gui.showResult(vehicleRepository.returnVehicle(gui.readPlate()));
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
