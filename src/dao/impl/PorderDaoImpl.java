package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

    public static void main(String[] args) {
        
//    	Add的寫法
//      Porder p= new Porder("ddd", 4, 4, 4); // 1. 創建 Porder 物件並設定屬性
//      new PorderDaoImpl().add(p);// 2. 呼叫 add 方法，將 p加入資料庫
    	
//    	Select的寫法
//    	PorderDaoImpl dao = new PorderDaoImpl();
//        List<Porder> orders = dao.selectById(1);// 取得 selectById(1) 的結果
//        for (Porder order : orders) {// 遍歷列表並輸出
//            System.out.println("ID: " + order.getId() + "\t" +
//                               "Name: " + order.getName() + "\t" +
//                               "LCD: " + order.getLcd() + "\t" +
//                               "RAM: " + order.getRam() + "\t" +
//                               "Mouse: " + order.getMouse());
//        }
    	
//    	Update的寫法
//    	Porder p=new PorderDaoImpl().selectById(1).get(0);
//		p.setLcd(100);
//		new PorderDaoImpl().update(p);
		
//    	Delete的寫法
//		new PorderDaoImpl().delete(3);
    	
    }
	
private static Connection conn=DbConnection.getDb();
	
	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,lcd,ram,mouse) values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(Sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getLcd());
			preparedstatement.setInt(3, porder.getRam());
			preparedstatement.setInt(4, porder.getMouse());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setLcd(resultset.getInt("lcd"));
				porder.setRam(resultset.getInt("ram"));
				porder.setMouse(resultset.getInt("mouse"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectById(int id) {
		String Sql="select * from porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setLcd(resultset.getInt("lcd"));
				porder.setRam(resultset.getInt("ram"));
				porder.setMouse(resultset.getInt("mouse"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set name=?,lcd=?,ram=?,mouse=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getLcd());
			preparedstatement.setInt(3, porder.getRam());
			preparedstatement.setInt(4, porder.getMouse());
			preparedstatement.setInt(5, porder.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}