package dao;

import java.util.List;

import metier.entities.Voyage;

public interface IVoyageDao {
public Voyage save(Voyage p);
public List<Voyage> VoyagesParMC(String mc);
public Voyage getVoyage(Long id);
public Voyage updateVoyage(Voyage p);
public void deleteVoyage(Long id);
}
