package lld.designpatterns.prototyperegistry;

public interface Prototype<T> {
  T clone();
}
