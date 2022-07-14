# SomeUtils/Clock

```java
package SomeUtils.Clock;
```

---

## Alarm.java

```java
import SomeUtils.Clock.Alarm;
```
---

### Public Variables

---

```java
public final static int millis;
public final static int seconds;
public final static int nanos;
```

These variables are for setting the unit of time.

---

```java
public interface AlarmWatcher{
  public void isRinging(boolean ringing);
}
```

This interface is used to listen for the Alarm.

---

### Public Methods

---

```java
public void start();
```

Used for starting the inner timer.

Not recommended to be called manually; it is automatically called.

---

```java
public void alarmAfter(final long duration, final int unit, final AlarmWatcher watcher);
```

---

## Stopwatch.java

```java
import SomeUtils.Clock.Stopwatch;
```
---

### Public Variables

---

```java
public final static int millis;
public final static int seconds;
public final static int nanos;
```

These variables are for setting the unit of time.

---

### Public Methods

---

```java
public void start();
```

Starts the stopwatch.

---

```java
public long getTimeElapsed();
public long getTimeElapsed(final int unit);
```

Gets the time elapsed after the stopwatch was started.

---

```java
public void lap();
public void split();
```

This records the current lap; splits.

---

```java
public long[][] getLaps();
```

Takes the lap/split method from the object.

---

## Timer.java

```java
import SomeUtils.Clock.Timer;
```
---

### Public Variables

```java
public final static int millis;
public final static int seconds;
public final static int nanos;
```

These variables are for setting the unit of time.

---

```java
public interface TimerWatcher{
  public void hasStopped(boolean stopped);
  public void timeElapsed(long nano, long millis, long seconds);
  public void timeLeft(long timeLeft);
}
```

Used to watch while the timer is running.

---

### Public Methods

```java
public void stopAfter(final long duration, final int unit);
```

Used to pause the thread for a duration.

---

```java
public void setWatcher(final TimerWatcher watcher);
```

Used to latch a watcher before calling the method above.

---