package util;

public class UtilErros {
	
	//capturando a mensagem de erro de nivel mais baixo
	public static String getMessagemErro(Exception e){
		while (e.getCause() != null){
			e = (Exception) e.getCause();
			
		}
		String retorno = e.getMessage();
		return retorno;
	}

}
