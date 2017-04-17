package MS.Service;

import java.util.List;

import unit.Result;

public interface DataService<T> {
   public Result getAll();
   public Result getById(int id);
   public Result add(T t);
   public Result update(T t);
}
