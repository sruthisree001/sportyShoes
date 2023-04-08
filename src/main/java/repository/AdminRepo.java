package repository;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
//import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Admin;

import org.springframework.stereotype.Component;



@Repository
@Component
public class AdminRepo {

	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Admin authenticate(String adminId, String pwd) {
		@SuppressWarnings("deprecation")
		List<Admin> list = this.sessionFactory.getCurrentSession().createQuery("from Admin where admin_id=:admin_id and admin_pwd=:admin_pwd")
				.setParameter("admin_id", adminId)
				.setParameter("admin_pwd", pwd)
				.list();
		if (list.size() > 0)
			return (Admin) list.get(0);
		else
			return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public Admin getAdminById(long id) {
		@SuppressWarnings("deprecation")
		List<Admin> list = this.sessionFactory.getCurrentSession().createQuery("from Admin where ID=:admin_id")
				.setParameter("admin_id", id)
				.list();
		if (list.size() > 0)
			return (Admin) list.get(0);
		else
			return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void updatePwd(Admin admin) {
		
		String sql = "update Admin set admin_pwd=:admin_pwd where ID=:id";
		@SuppressWarnings("deprecation")
		Query<String> query = this.sessionFactory.getCurrentSession().createQuery(sql).setParameter("admin_pwd", admin.getAdminPwd()).setParameter("id", admin.getID());
		
		query.executeUpdate();
		
	}

	
}
