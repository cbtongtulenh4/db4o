package Nhom4.repository;

import Nhom4.entity.GiaoVien;
import Nhom4.entity.HocVien;
import Nhom4.entity.KhoaHoc;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private ObjectContainer objectContainer = DB4OUtil.getInstance().createConnection();

    public ObjectContainer getObjectContainer() {
        return objectContainer;
    }

    public void insert(Object object){
        objectContainer.store(object);
    }

    public void updateGiaoVien(long id, GiaoVien gv){
        GiaoVien ori = findGiaoVienById(id);
        if(ori != null){
            gv.setId(id);
            objectContainer.store(gv);
            System.out.println("update success");
            return;
        }
        System.out.println("update failure");
    }

    public void deleteGiaoVienById(long id){
        GiaoVien ob = findGiaoVienById(id);
        if(ob != null){
            objectContainer.delete(ob);
            System.out.println("delete success");
            return;
        }
        System.out.println("delete failure");
    }

    public void updateHocVien(long id, HocVien ob){
        HocVien ori = findHocVienById(id);
        if(ori != null){
            ob.setId(id);
            objectContainer.store(ob);
            System.out.println("update success");
            return;
        }
        System.out.println("update failure");
    }

    public void updateKhoaHoc(long id, KhoaHoc ob){
        KhoaHoc ori = findKhoaHocById(id);
        if(ori != null){
            ob.setId(id);
            objectContainer.store(ob);
            System.out.println("update success");
            return;
        }
        System.out.println("update failure");
    }

    public void deleteHocVienById(long id){
        HocVien ob = findHocVienById(id);
        if(ob != null){
            objectContainer.delete(ob);
            System.out.println("delete success");
            return;
        }
        System.out.println("delete failure");
    }


    public void updateNameGiaoVienById(long id, String name){
        GiaoVien gv = findGiaoVienById(id);
        gv.setTen(name);
        objectContainer.store(gv);
    }

    public void updateNameHocVienById(long id, String name){
        HocVien hv = findHocVienById(id);
        hv.setTen(name);
        objectContainer.store(hv);
    }


    public void updateNameKhoaHocById(long id, String name){
        KhoaHoc kh = findKhoaHocById(id);
        kh.setTen(name);
        objectContainer.store(kh);
    }

    public void deleteKhoaHocById(long id){
        KhoaHoc ob = findKhoaHocById(id);
        if(ob != null){
            objectContainer.delete(ob);
            System.out.println("delete success");
            return;
        }
        System.out.println("delete failure");
    }


    public <T> List<T> getAll(Class<T> tclass){
        ObjectSet listData = objectContainer.queryByExample(tclass);
        List<T> rs = new ArrayList<>();
        for (Object value : listData){
            rs.add((T) value);
        }
        return rs;
    }


    public GiaoVien findGiaoVienById(long id){
        GiaoVien ob = new GiaoVien();
        ob.setId(id);
        ObjectSet rs = objectContainer.queryByExample(ob);
        ob = null;
        while (rs.hasNext()){
            ob = (GiaoVien) rs.next();
        }
        return ob;
    }

    public HocVien findHocVienById(long id){
        HocVien ob = new HocVien();
        ob.setId(id);
        ObjectSet rs = objectContainer.queryByExample(ob);
        ob = null;
        while (rs.hasNext()){
            ob = (HocVien) rs.next();
        }
        return ob;
    }

    public KhoaHoc findKhoaHocById(long id){
        KhoaHoc ob = new KhoaHoc();
        ob.setId(id);
        ObjectSet rs = objectContainer.queryByExample(ob);
        ob = null;
        while (rs.hasNext()){
            ob = (KhoaHoc) rs.next();
        }
        return ob;
    }

    public int countSumOfObject(Class<?> tclass){
        return objectContainer.queryByExample(tclass).size();
    }

    public List<KhoaHoc> findAllKhoaHocNotStart(){
        ObjectSet listData = objectContainer.queryByExample(KhoaHoc.class);
        List<KhoaHoc> rs = new ArrayList<>();
        for (Object kh : listData){
            rs.add((KhoaHoc) kh);
        }
        return rs.parallelStream().filter(kh -> TimeUtil.convertStringToDateByFormat(kh.getStartDay(), "dd/MM/yyyy").getTime() - System.currentTimeMillis() > 0).collect(Collectors.toList());
    }

    public void cancelKhoaHoc(long hocVienID, long khoaHocID){
        KhoaHoc kh = findKhoaHocById(khoaHocID);
        HocVien hv = findHocVienById(hocVienID);
        if(kh != null && hv != null){
            hv.removeKhoaHoc(kh.getId());
            objectContainer.store(hv);
            objectContainer.store(kh);
            System.out.println("Cancel success");
            return;
        }
        System.out.println("Cancel Failure");
    }

    public <T> T getLastObject(Class<T> clazz){
        ObjectSet listData = objectContainer.queryByExample(clazz);
        int index = listData.size()-1;
        return (index < 0) ? null : (T)listData.get(index);
    }
    public void updateGiaoVienOfKhoaHocById(long khoaHocID, long giaoVienID){
        KhoaHoc khoaHoc = findKhoaHocById(khoaHocID);
        GiaoVien gv = findGiaoVienById(giaoVienID);
        if(khoaHoc != null && gv != null) {
            khoaHoc.getGiaoVien().removeKhoaHoc(khoaHoc.getId());
            gv.addKhoaHoc(khoaHoc);
            objectContainer.store(gv);
            objectContainer.store(khoaHoc);
            System.out.println("Update Success");
            return;
        }
        System.out.println("Error Occur");
    }

    public void registrationKhoaHoc(long hocVienID, long khoaHocID){
        KhoaHoc kh = findKhoaHocById(khoaHocID);
        HocVien hv = findHocVienById(hocVienID);
        if(kh != null && hv != null){
            hv.addKhoaHoc(kh);
            objectContainer.store(hv);
            objectContainer.store(kh);
            System.out.println("Registered success");
            return;
        }
        System.out.println("Registered Failure");
    }

}