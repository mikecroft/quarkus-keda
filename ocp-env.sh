
# Borrow Swinches' hard work for AMQ with prom JMX exporter
oc import-image jboss-amq-63 --from=registry.access.redhat.com/jboss-amq-6/amq63-openshift --confirm -n openshift
oc new-build registry.access.redhat.com/jboss-amq-6/amq63-openshift:latest~https://github.com/welshstew/amq63-prom-sti.git
curl https://raw.githubusercontent.com/welshstew/amq63-prom-sti/master/amq63-basic-prom.json | oc create -f -

oc new-app --template=amq63-basic-prom \
    -p MQ_PROTOCOL="openwire,amqp,mqtt" \
    -p MQ_USERNAME=quarkus \
    -p MQ_PASSWORD=quarkus

