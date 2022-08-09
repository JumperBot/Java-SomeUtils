# SomeUtils/ProgressBar

```java
package SomeUtils.ProgressBar;
```

---

## ProgressBar.java

```java
import SomeUtils.ProgressBar.ProgressBar;
```
---

### Public Methods

---

```java
public ProgressBar(final int maxVal);
public ProgressBar(final int minVal, final int maxVal);
```

Two ways of initializing the ProgressBar.

---

```java
public int getValue();
public int getMaxValue();
public int[] getValues();
```

Gets the progress or the max value the ProgressBar can hold...

...Or both of them at the same time.

---

```java
public void setValue(final int newValue);
public void addValue();
public void deductValue();
```

Sets the value of the progress in three different ways...

...By setting the value yourself, adding or deducting to it.

---

```java
public void setMessage(final String message);
public String getMessage();
```

Sets or gets the message by the side of the progress bar.

---

```java
public void printBar();
```

Prints the ProgressBar itself.

---