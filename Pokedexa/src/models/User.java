package models;

public class User {
	private String nick;
	private String passwd;
	
	
	
	/**
	 * @param nick
	 * @param passwd
	 */
	public User(String nick, String passwd) {
		super();
		this.nick = nick;
		this.passwd = passwd;
	}
	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
