package filmator.model;

public class Usuario {
		private int idUsuario;
		private String login;
		private String adm;
		
		public Usuario() {
			
		}
		
		public Usuario(String login){
			this.login = login;			
		}
		public String getLogin() {
			return login;
		}
		public String getAdm() {
			return adm;
		}
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public void setAdm(String adm) {
			this.adm = adm;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}

}
