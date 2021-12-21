package edu.umn.cs.csci3081w.project.model;

public class BusFactory implements VehicleFactory {
  private GenerationStrategy generationStrategy;
  private Counter counter;
  private StorageFacility storageFacility;

  /**
   * Constructor for bus factory that selects strategy based on time.
   *
   * @param storageFacility storage facility information
   * @param counter counter information
   * @param time time used to select strategy
   */
  public BusFactory(StorageFacility storageFacility, Counter counter, int time) {
    if (time >= 8 && time < 16) {
      generationStrategy = new BusStrategyDay();
    } else {
      generationStrategy = new BusStrategyNight();
    }
    this.storageFacility = storageFacility;
    this.counter = counter;
  }

  /**
   * Generate Vehicle at specific line.
   * @param line the line want ot add a vehicle
   * @return vehicle on this line
   */
  @Override
  public Vehicle generateVehicle(Line line) {
    String typeOfVehicle = generationStrategy.getTypeOfVehicle(storageFacility);
    Vehicle generatedVehicle = null;
    if (typeOfVehicle != null && typeOfVehicle.equals(SmallBus.SMALL_BUS_VEHICLE)) {
      generatedVehicle = new SmallBusDecorator(
          new SmallBus(counter.getSmallBusIdCounterAndIncrement(), line,
              SmallBus.CAPACITY, SmallBus.SPEED));
      storageFacility.decrementSmallBusesNum();
    } else if (typeOfVehicle != null && typeOfVehicle.equals(LargeBus.LARGE_BUS_VEHICLE)) {
      generatedVehicle = new LargeBusDecorator(
          new LargeBus(counter.getLargeBusIdCounterAndIncrement(), line,
              LargeBus.CAPACITY, LargeBus.SPEED));
      storageFacility.decrementLargeBusesNum();
    }
    return generatedVehicle;
  }

  /**
   * When vehicle finish service, let storage facility get one vehicle count back.
   * @param vehicle current vehicle stop service
   */
  @Override
  public void returnVehicle(Vehicle vehicle) {
    if (vehicle instanceof SmallBusDecorator) {
      storageFacility.incrementSmallBusesNum();
    } else if (vehicle instanceof LargeBusDecorator) {
      storageFacility.incrementLargeBusesNum();
    }
  }

  /**
   * Get storage facility.
   *
   * @return storage facility
   */
  public StorageFacility getStorageFacility() {
    return storageFacility;
  }

  /**
   * Get generation strategy.
   *
   * @return generation strategy
   */
  public GenerationStrategy getGenerationStrategy() {
    return generationStrategy;
  }

  /**
   * Set generation strategy.
   *
   * @param st vehicle generation strategy
   */
  public void setGenerationStrategy(GenerationStrategy st) {
    this.generationStrategy = st;
  }

}
