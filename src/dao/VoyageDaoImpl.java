package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Voyage;

public class VoyageDaoImpl implements IVoyageDao {

	@Override
	public Voyage save(Voyage p) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO VoyageS(NOM_Voyage,PRIX) VALUES(?,?)");
			ps.setString(1, p.getNomVoyage());
			ps.setDouble(2, p.getPrix());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_Voyage) as MAX_ID FROM VoyageS");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				p.setIdVoyage(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Voyage> VoyagesParMC(String mc) {
	      List<Voyage> prods= new ArrayList<Voyage>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from VoyageS where NOM_Voyage LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Voyage p = new Voyage();
				p.setIdVoyage(rs.getLong("ID_Voyage"));
				p.setNomVoyage(rs.getString("NOM_Voyage"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods;
	}

	@Override
	public Voyage getVoyage(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		    Voyage p = new Voyage();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from VoyageS where ID_Voyage = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				p.setIdVoyage(rs.getLong("ID_Voyage"));
				p.setNomVoyage(rs.getString("NOM_Voyage"));
				p.setPrix(rs.getDouble("PRIX"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return p;
	}

	@Override
	public Voyage updateVoyage(Voyage p) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE VoyageS SET NOM_Voyage=?,PRIX=? WHERE ID_Voyage=?");
			ps.setString(1, p.getNomVoyage());
			ps.setDouble(2, p.getPrix());
			ps.setLong(3, p.getIdVoyage());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteVoyage(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM VoyageS WHERE ID_Voyage = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
