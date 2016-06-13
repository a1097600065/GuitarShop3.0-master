package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DbUtil;
import dao.IGuitarDao;
import model.*;

public class GuitarImpl implements IGuitarDao{
	
	@Override
	public boolean LoadGuitars(){
		Inventory inventory = new Inventory();
		// 初始化inventory
		String sql = "select * from guitar3";
		Connection Conn = DbUtil.getSqliteConnection();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String builder = rs.getString("builder");
				String model = rs.getString("model");
				String type = rs.getString("type");
				int numStrings = Integer.parseInt(rs.getString("numStrings"));
				String backWood = rs.getString("backWood");
				String topWood = rs.getString("topWood");
				GuitarSpec Spec = new GuitarSpec(builder, model, type, numStrings, backWood, topWood);
				inventory.addGuitar(rs.getString("serialNumber"), Double.parseDouble(rs.getString("price")), Spec);
			}
			rs.close();
			pstmt.close();
			Conn.close();
		}catch(Exception e){
		    e.printStackTrace();	
		}
		return true;
	}

	@Override
	public boolean addGuitar(String serialNumber, double price, GuitarSpec spec) {
		Connection Conn = DbUtil.getSqliteConnection();
		String sql = "insert into guitar3(serialNumber,builder,model,type,backWood,topWood,numStrings,price) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setString(2, spec.getBuilder().toString());
			pstmt.setString(3, spec.getModel());
			pstmt.setString(4, spec.getType().toString());
			pstmt.setString(5, spec.getBackWood().toString());
			pstmt.setString(6, spec.getTopWood().toString());
			pstmt.setInt(7, spec.getnumStrings());
			pstmt.setDouble(8, price);
			pstmt.executeUpdate();
			System.out.println("添加成功");
			pstmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	

	
	@Override
	public void deleteGuitar(String serialNumber){
		Connection conn = DbUtil.getSqliteConnection();
		String sql = "delete from guitar3 where serialNumber='"+serialNumber+"'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除异常："+e.getMessage());
		}
	} 
}
