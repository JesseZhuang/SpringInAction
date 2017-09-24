package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  /**
   * find spittles with count and maxID
   * @param max the maximum ID of any Spittle that should be returned
   * @param count how many Spittle objects to return
   * @return
   */
  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
