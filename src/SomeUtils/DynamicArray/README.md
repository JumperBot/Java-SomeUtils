# SomeUtils/DynamicArray;

```java
package SomeUtils.DynamicArray;
```

---

## DynamicArray.java

```java
import SomeUtils.DynamicArray.DynamicArray;
```
---

### Public Methods

---

```java
public DynamicArray();
public DynamicArray(final T[] newArr);
```

Create an instance with or without an array preset.

---

```java
public void set(final int ind, final T value);
```

Set the value for the specified index.

---

```java
public T get(final int ind);
```

Get the value for the specified index.

---

```java
public T[] toArray();
public T[] getArray();
```

Get a fixed-length copy of the underlying array.

A much more recommended way of getting the array.

---

```java
public T[] getRealArray();
```

Get the actual underlying array.

Not recommended for the length of the array is inflated.

---