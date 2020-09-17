package tutorial.exemplo_03;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jade.Boot;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

/**
 * Class that starts the <b>{@link CompradorDeLivros}</b> agent.
 * 
 * @author Francisco Cunha
 * @version jade 4.5.0
 */
public class StartAgent {

	private static final Log log = LogFactory.getLog(StartAgent.class);

	/**
	 * Constructor
	 * 
	 * @param agent         the class that implements the agent.
	 * @param nameAgent     the name of the agent.
	 * @param nameContainer the name of the container.
	 */
	public StartAgent(Agent agent, String nameAgent, String nameContainer) {
		setAgentInContainer(agent, nameAgent, nameContainer);
	}

	/**
	 * Set the parameters of the environment.
	 * 
	 * @param agent         the class that implements the agent.
	 * @param nameAgent     the name of the agent.
	 * @param nameContainer the name of the container.
	 */
	private static void setAgentInContainer(Agent agent, String nameAgent, String nameContainer) {

		Runtime runtime = Runtime.instance();
		runtime.setCloseVM(true);

		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.CONTAINER_NAME, nameContainer);

		AgentContainer controllerAgentContainer = runtime.createAgentContainer(profile);

		try {

			AgentController controller = controllerAgentContainer.acceptNewAgent(nameAgent, agent);

			controller.start();

		} catch (StaleProxyException ex) {
			log.debug("The agent cannot be started!");
		}
	}

	/**
	 * This is the entry point of the class.
	 * 
	 * @param args array of input parameters.
	 * 
	 */
	public static void main(String[] args) {

		Boot.main(new String[] { "-gui" });
		CompradorDeLivros comprador = new CompradorDeLivros();
		//comprador.setArguments(new String[] { "O Pequeno Príncipe", "Padrões de Projeto em Java" });
		new StartAgent(comprador, "info", "container");

	}
}
