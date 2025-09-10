interface Explorer {
    void explore();
}

abstract class Planet {
    protected String name;

    public Planet(String name) {
        this.name = name;
    }

    // Template method: common behavior is defined here.
    public final void traverse(Explorer explorer) {
        explorer.explore();
        System.out.println(getExplorationMessage());
    }

    // Each planet provides its own exploration message.
    protected abstract String getExplorationMessage();
}

class Mars extends Planet {
    public Mars() {
        super("Mars");
    }

    @Override
    protected String getExplorationMessage() {
        return "Exploring the rocky surface and other unique features of Mars.";
    }
}

class Venus extends Planet {
    public Venus() {
        super("Venus");
    }

    @Override
    protected String getExplorationMessage() {
        return "Analyzing the thick atmosphere and other unique features of Venus.";
    }
}

class Saturn extends Planet {
    public Saturn() {
        super("Saturn");
    }

    @Override
    protected String getExplorationMessage() {
        return "Investigating the gaseous surface and other unique features of Saturn.";
    }
}

class GeologicalExplorer implements Explorer {
    @Override
    public void explore() {
        System.out.println("Conducting intensive geological surveys.");
    }
}

class AtmosphericExplorer implements Explorer {
    @Override
    public void explore() {
        System.out.println("Studying atmospheric conditions.");
    }
}

class BiologicalExplorer implements Explorer {
    @Override
    public void explore() {
        System.out.println("Searching for signs of life.");
    }
}

public class q9 {
    public static void main(String[] args) {
        Planet mars = new Mars();
        Planet venus = new Venus();
        Planet saturn = new Saturn();

        Explorer geoExplorer = new GeologicalExplorer();
        Explorer atmosExplorer = new AtmosphericExplorer();
        Explorer bioExplorer = new BiologicalExplorer();

        System.out.println("Exploring Mars:");
        mars.traverse(geoExplorer);

        System.out.println("\nExploring Venus:");
        venus.traverse(atmosExplorer);

        System.out.println("\nExploring Saturn:");
        saturn.traverse(bioExplorer);
    }
}
