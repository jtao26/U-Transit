package edu.umn.cs.csci3081w.project.model;

import java.io.PrintStream;

public abstract class Bus extends Vehicle {
  public static final String BUS_VEHICLE = "BUS_VEHICLE";

  /**
   * Constructor for a bus.
   *
   * @param id       bus identifier
   * @param line     route of in/out bound
   * @param capacity capacity of bus
   * @param speed    speed of bus
   */
  public Bus(int id, Line line, int capacity, double speed) {
    super(id, line, capacity, speed, new PassengerLoader(), new PassengerUnloader());
  }

  /**
   * Report statistics for the bus.
   * @param out stream for printing
   */
  public void report(PrintStream out) {

  }
}
