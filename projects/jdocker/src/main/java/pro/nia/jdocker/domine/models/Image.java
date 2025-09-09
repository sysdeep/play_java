package pro.nia.jdocker.domine.models;

public class Image {
  public String id;
  public String created;
  public Long size;
  public String[] tags;
}

// public record ImageDTO(String id){}

/*
 * 
 * InspectImageResponse(
 * arch=amd64,
 * author=,
 * comment=buildkit.dockerfile.v0,
 * config=ContainerConfig(attachStderr=null,
 * attachStdin=null,
 * attachStdout=null,
 * cmd=null,
 * domainName=null,
 * entrypoint=[kafka-configurator-run],
 * env=[PATH=/opt/venv/python-build/bin:/opt/python-3.11.9-ubuntu22/bin:/usr/
 * local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin,
 * USER=root,
 * TZ=UTC,
 * RUN_USER_NAME=kluser,
 * RUN_USER_GROUP=klusers,
 * LANG=en_US.utf8,
 * LANGUAGE=en_US:en,
 * LC_ALL=en_US.utf8],
 * exposedPorts=null,
 * hostName=null,
 * image=null,
 * labels={org.opencontainers.image.ref.name=ubuntu,
 * org.opencontainers.image.version=22.04},
 * macAddress=null,
 * networkDisabled=null,
 * onBuild=null,
 * stdinOpen=null,
 * portSpecs=null,
 * stdInOnce=null,
 * tty=null,
 * user=kluser,
 * volumes=null,
 * workingDir=/,
 * healthCheck=null),
 * container=null,
 * containerConfig=null,
 * created=2025-08-21T12:01:31.513177717+03:00,
 * dockerVersion=,
 * id=sha256:937d502449d79b2dfc76439c6fb775ce7c913596ee99f791375eac3f4264832f,
 * os=linux,
 * osVersion=null,
 * parent=,
 * size=303932559,
 * repoTags=[
 * 172.28.1.1:5000/kaspersky/kata/kafka/kafka_configurator:1755766892],
 * repoDigests=[
 * 172.28.1.1:5000/kaspersky/kata/kafka/kafka_configurator@sha256:
 * 31bc0ab4e0dd871f07df1675b1d26d218e4b81a081b1eea51ac1190e2b263501],
 * virtualSize=null,
 * graphDriver=GraphDriver(name=overlay2, data=GraphData(rootDir=null,
 * deviceId=null, deviceName=null, deviceSize=null, dir=null)),
 * rootFS=RootFS(type=layers, layers=[sha256:
 * b8a36d10656ac19ddb96ef3107f76820663717708fc37ce929925c36d1b1d157,
 * sha256:a692a1c8f9c0679917eb08471f490969d68f5b033dc76bd8a33cd3a877d28f35,
 * sha256:257ca7a43061677b5cb49e6113f31c63705b69ab784b1ff1be1354f4f5c20179,
 * sha256:9b30e70048e400ae7da87a17ddf226823e4b279d6fd06e31f2c7c3cd1c2410f3,
 * sha256:5d1069fc93baa4c5d7af1503f5f5f03cc9bf746ad8b646faa6a8be9ac3ee56bf,
 * sha256:09d468f89c806636bffc57269e181f6ae9458f9a7b4fe664b055f689374e38ae,
 * sha256:5f70bf18a086007016e948b04aed3b82103a36bea41755b6cddfaf10ace3c6ef,
 * sha256:d77fd285e9eebdfe1d97ee668ce59cede68aa149ea9ec34e40178914fbe85c44,
 * sha256:d0efb475ccaf0e3d7ce5e5c201bd45a690a2869061dd4a1168399510e1c155c7,
 * sha256:6adf354a0da119831cda23e7ffaab3c977de12f4ce03b0e5880f4c87a4b1041a,
 * sha256:0fc5453a421a32e3b864e13bc526ef3b3d9abd5ac63d249ab3bc831121ce9eb6,
 * sha256:2eb2eedd67faba8337dea792f1093cb96a5dc6d999b04fb2cce05b321dc5cb06,
 * sha256:420443ae2f9ed5f943b4c1e81a4ce62ee6d3bb960d3514355c05a1792afb607a,
 * sha256:b7ca271486d3c7892a4feb29cb345bc176848504667361117bb1456b8c7fe6ae]))
 */
