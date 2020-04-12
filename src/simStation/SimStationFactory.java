package simStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public abstract class SimStationFactory implements AppFactory {

    public abstract View getView(Model model);

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        switch (type) {
            case "Start":
                return new StartCommand(model);
            case "Suspend":
                return new SuspendCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Stats":
                return new StatsCommand(model);
            default:
                return null;
        }
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return "SimStation, by Hui Tang, Phuc Phan and Zheng-Yao Chin";
    }
}
