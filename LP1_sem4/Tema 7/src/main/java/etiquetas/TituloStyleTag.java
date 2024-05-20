package etiquetas;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TituloStyleTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException{
		JspWriter writer = pageContext.getOut();
		try {
			writer.print("hola a todos");
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	

}
