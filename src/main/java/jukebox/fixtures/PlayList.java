package jukebox.fixtures;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
  public List<Object> query() {
    List<Object> table = list();
    List<String> songs = JukeBox.jukeBox.getPlayList();
    for (int i = 0; i < songs.size(); i++) {
      String id =  songs.get(i);
      List<Object> row = list(list("index", i+1), list("id", id), list("title", JukeBox.jukeBox.getTitleOf(id)));
      table.add(row);
    }
    return table;
  }

  public List<Object> list(Object... objects) {
    List<Object> list = new ArrayList<Object>();
    for (Object o : objects) {
      list.add(o);
    }
    return list;
  }
}
