package pojo;
// Generated Oct 11, 2022 1:20:50 PM by Hibernate Tools 4.3.1

import DAO.DAOAdmins;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * Admins generated by hbm2java
 */

@ManagedBean
public class Admins  implements java.io.Serializable {


     private Integer idAdmin;
     private String adminName;
     private String email;
     private String password;

    public Admins() {
    }

    public String loginValidation(){
        DAOAdmins uDao = new DAOAdmins();
        List<Admins> ad = uDao.getBy(email, password);
        try {
            if (ad != null) {
                email = ad.get(0).email;
                password = ad.get(0).password;
                return "album_list";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "login_failed";
    }
    
    public String save_admin() {
        DAOAdmins add = new DAOAdmins();
        return add.add_admin(this);
    }
    
    public Admins(String adminName, String email, String password) {
       this.adminName = adminName;
       this.email = email;
       this.password = password;
    }
   
    public Integer getIdAdmin() {
        return this.idAdmin;
    }
    
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String deleteAdmin(){
        DAOAdmins admin = new DAOAdmins();
        admin.deleteAdmin(idAdmin);
        
        return "admin_list";
    }
    
    public String getbyID(){
        String id = idAdmin.toString();
        DAOAdmins admin = new DAOAdmins();
        List<Admins> lAdmin = admin.getbyID(id);
        try {
            if (lAdmin != null) {
                adminName = lAdmin.get(0).adminName;
                email = lAdmin.get(0).email;
                password = lAdmin.get(0).password;
                
                return "admin_form";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        adminName = "";
        email = "";
        password = "";
        return "admin_form_failed";
    }
    
    public List<Admins> getAllRecords(){
        DAOAdmins admin = new DAOAdmins();
        List<Admins> lAdmin = admin.retrieveTblAdmin();
        return lAdmin;
    }
    
    public String updateAdmin(){
        DAOAdmins admin = new DAOAdmins();
        admin.updateAdmin(this);
        
        return "admin_list";
    }

    public String resetAdmin(){
        DAOAdmins admin = new DAOAdmins();
        admin.resetAdmin(idAdmin);
        idAdmin = 0;
        adminName = "";
        email = "";
        password = "";
        
        return "admin_form";
    }
}


