# SomeUtils/Storage

```java
package SomeUtils.Storage;
```

---

## Inventory.java

```java
import SomeUtils.Storage.Inventory;
```
---

### Public Methods

---

```java
public Inventory<Item>(final int size);
```

Initialize the Inventory by setting its size.

---

```java
public void setStackable();
```

Make the items inside the Inventory stackable or non-stackable...

...The items are non-stackable by default.

---

```java
public void stack();
public void pack();
```

Make the scattered items in the Inventory stack altogether...

...Or just pack them altogether in a smaller space.

---

```java
public boolean store(final Item item, final int ind);
public void storeMultiple(final Item... items);
```

Try to store an item in the Inventory and see if it gets stored...

...Or just store multiple items all at once.

---

```java
public void drop(final int ind);
public void dropAll(final int ind);
public void clear();
```

Either drop a single item in a slot...

...Or just drop everything in a slot...

...Or just clear the Inventory altogether.

---

```java
public Item get(final int ind);
public Item getAndDrop(final int ind);
```

Either just get the item in a slot...

...Or just get and drop an item in a slot.

---

```java
public int getItemCount(final int ind);
public int[] getItemCounts();
```

Get the quantity of items in a slot...

...Or just get the quantities of all items altogether.

---

```java
public String[] toArray();
public String[] getArray();
```

Get a copy of the internal Item array.

---

```java
public int size();
public int length();
```

Get the size / length of the Inventory.

---
