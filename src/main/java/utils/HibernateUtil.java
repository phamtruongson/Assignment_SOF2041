package utils;

import domainmodels.ChiTietSP;
import domainmodels.ChucVu;
import domainmodels.CuaHang;
import domainmodels.DongSP;
import domainmodels.GioHang;
import domainmodels.GioHangChiTiet;
import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import domainmodels.KhachHang;
import domainmodels.MauSac;
import domainmodels.NSX;
import domainmodels.NhanVien;
import domainmodels.SanPham;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author sonpt_ph19600
 */

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "false");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);

        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
