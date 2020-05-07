import com.google.inject.Guice;
import com.google.inject.Injector;
import health.CollegeSuiteHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.BookController;
import resources.SemesterResource;
import resources.StudentResource;

public class CollegeSuiteApplication extends Application<CollegeSuiteServiceConfiguration> {
    public static final String APPLICATION_NAME = "college-suite-application";
    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeSuiteApplication.class);

    @Override
    public String getName() {
        return APPLICATION_NAME;
    }

    @Override
    public void initialize(Bootstrap<CollegeSuiteServiceConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(CollegeSuiteServiceConfiguration configuration, Environment environment)
            throws Exception {
        environment.healthChecks().register(this.getName(), new CollegeSuiteHealthCheck());
        environment.jersey().register(new StudentResource());
        environment.jersey().register(new BookController());
        environment.jersey().register(new SemesterResource());
        LOGGER.info("All resources added for college-suite");
    }

    public static void main(String []args) throws Exception {
        new CollegeSuiteApplication().run(args);
    }
}
