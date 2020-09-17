package tutorial.exemplo_03;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jade.core.Agent;

/**
 * A simple agent that says Hello World.
 * 
 * @author Francisco Cunha
 * @version jade 4.5.0
 */
public class CompradorDeLivros extends Agent {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(CompradorDeLivros.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setup() {
		String livrosComprar = null;
		log.debug("Olá eu sou o agente comprador " + getLocalName() + " e estou pronto para comprar!");
		Object[] args = getArguments();
		if (args != null && args.length > 0) {
			livrosComprar = (String) args[0];
			log.debug("Pretendendo comprar o livro " + livrosComprar);
		} else {
			log.debug("Não tenho livros para comprar");
			doDelete();
		}
	}

	@Override
	protected void takeDown() {
		log.debug("Agente comprador " + getAID().getName() + " está finalizado!");
	}
}
