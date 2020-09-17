package tutorial.exemplo_02;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jade.core.Agent;

/**
 * A simple agent that says Hello World.
 * 
 * @author Francisco Cunha
 * @version jade 4.5.0
 */
public class InfoAgentes extends Agent {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(InfoAgentes.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setup() {
		log.debug("Hello World! Eu sou um agente!");
		log.debug("Todas as minhas informações: \n" + getAID());
		log.debug("Meu nome local é " + getAID().getLocalName());
		log.debug("Meu nome global (GUID) é " + getAID().getName());
		log.debug("Meus endereços são:");
		Iterator<?> it = getAID().getAllAddresses();
		while (it.hasNext()) {
			log.debug("– " + it.next());
		}
	}
}
