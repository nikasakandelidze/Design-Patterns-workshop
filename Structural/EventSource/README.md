## Event Sourcing
    Instead of storing just the current state of the data in a domain,
    use an append-only store to record the full series of actions taken on that data.
    The store acts as the system of record and can be used to materialize the domain objects.
    This can simplify tasks in complex domains, by avoiding the need to synchronize the data model and the business domain