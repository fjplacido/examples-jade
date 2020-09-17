package tutorial.exemplo_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jade.core.Agent;

/**
 * A simple agent that says Hello World.
 * 
 * @author Francisco Cunha
 * @version jade 4.5.0
 */
public class HelloWorld extends Agent {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(HelloWorld.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setup() {
		log.debug("Hello World!");
		log.debug("Meu nome é " + getLocalName());
	}
}
