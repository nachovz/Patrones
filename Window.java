package patrones;

import java.util.Hashtable;
import java.util.Vector;
import patrones.Cartelera.Iterator;

public class Window extends javax.swing.JFrame {
    Login login;
    Cartelera board;
    Busqueda busq;
    Requerimiento hash, req;
    int reqid, numreq;
    Iterator boardIt;
    Vector<String> rows;
    Vector<Vector> table;
	private int sesion;
    
    public void fillTable(){
        System.out.println("fill");
        Requerimiento reqTab;
        rows.clear();
        table.clear();
        boardIt = board.create_iterator();
        boardIt.first();
        while(!boardIt.is_done()){
            //"RequestID", "Nombre Consultor", "Codigo Consultor", "GG Ejecutor", "G Ejecutor", "Extension"
            rows.clear();
            reqTab=boardIt.current_item();
            System.out.println("reqTab "+reqTab);
            rows.add(reqTab.get("requestID").toString());
            rows.add(reqTab.get("nombreS").toString());
            rows.add(reqTab.get("codigoS").toString());
            rows.add(reqTab.get("ggS").toString());
            rows.add(reqTab.get("gS").toString());
            rows.add(reqTab.get("extensionC").toString());
            table.add(rows);
            boardIt.next();
        }
    
    }

    public void setInfoSolicitante(){
        //Datos del Requerimiento
            hash.put("certificacion", certReqComboBox.getSelectedItem().toString());
            hash.put("nombre", nombreReqTextField.getText().toString());
            hash.put("descripcion", descTextField.getText().toString());
            hash.put("dsaa", DSAAComboBox.getSelectedItem().toString());
            hash.put("aplicacion", aplicacionComboBox.getSelectedItem().toString());
            hash.put("prioridad", prioridadComboBox.getSelectedItem().toString());
            hash.put("impactoNegocio", impactoComboBox.getSelectedItem().toString());
            hash.put("justificacion", obsTextField.getText().toString());
            hash.put("fechaEsperada", fechaEspTextField.getText().toString());
            hash.put("fechaCertificacion", fechaCertTextField.getText().toString());           
        //Datos del Solicitante
            hash.put("nombreS", nombreSolTextField.getText().toString());
            hash.put("codigoS", codigoSolTextField.getText().toString());
            hash.put("vpS", VPSolComboBox.getSelectedItem().toString());
            hash.put("ggS", GGSolComboBox.getSelectedItem().toString());
            hash.put("gS", GSolComboBox.getSelectedItem().toString());
        //Datos de la Persona de Contacto
            hash.put("nombreC", nombreContTextField.getText().toString());
            hash.put("vpC", VPContComboBox.getSelectedItem().toString());
            hash.put("ggC", GGContComboBox.getSelectedItem().toString());
            hash.put("gC", GContComboBox.getSelectedItem().toString());
            hash.put("extensionC", extTextField.getText().toString());
    }
    
    public void setInfoFuncional(){
        //Datos Comite
            hash.put("statusCom", statusComTIComboBox.getSelectedItem().toString());
            hash.put("observacionesCom", obsComTextField.getText().toString());
            hash.put("fechaCanceladoCom", fechaCancTextField.getText().toString());
            hash.put("fechaPendienteCom", fechaPendTextField.getText().toString());
            hash.put("gciaCom", gerenciaTextField.getText().toString());
            hash.put("prioridadCom", prioridadComboBox.getSelectedItem().toString());
            hash.put("fechaCom", fechaComTextField.getText().toString());
            hash.put("fechaFactibilidadCom", fechaFactTextField.getText().toString());
            hash.put("fechaRequiereCom", fechaReqTextField.getText().toString());

        //Datos Requerimiento
            hash.put("tipo", tipoReqComboBox.getSelectedItem().toString());
            hash.put("subtipo", subtipoReqComboBox.getSelectedItem().toString());
            hash.put("fechaInicioEst", fechaEstTextField.getText().toString());
            hash.put("complejidad", compComboBox.getSelectedItem().toString());
            hash.put("solicitud", solicitudComboBox.getSelectedItem().toString());

        //Datos del Responsable Funcional (TI)
            hash.put("nombreResp", fechaEstTextField.getText().toString());
            hash.put("codigoResp", fechaEstTextField.getText().toString());
            hash.put("ggResp", GGRespFuncComboBox.getSelectedItem().toString());
            hash.put("gResp", GRespFuncComboBox.getSelectedItem().toString());
    }
    
    public void setInfoImplementacion(){
        //Fechas Requerimiento
            hash.put("fechaInicio", fechaInTextField.getText().toString());
            hash.put("fechaCulminacionEst", fechaEstCulmTextField.getText().toString());
            hash.put("fechaCulminacion", fechaCulmTextField.getText().toString());
        //Datos de Requerimiento
            hash.put("costo", costoTextField.getText().toString());
            hash.put("moneda", monedaComboBox.getSelectedItem().toString());
            hash.put("impactoTecnico", impactoTecComboBox.getSelectedItem().toString());
            hash.put("observaciones", obsImpTextField.getText().toString());
        //Datos del Responsable Implementacion/Ejecucion
            hash.put("nombreRespI", nombreRespImpTextField.getText().toString());
            hash.put("codigoRespI", codRespImpTextField.getText().toString());
            hash.put("ggRespI", GGRespImpComboBox.getSelectedItem().toString());
            hash.put("gRespI", GRespImpComboBox.getSelectedItem().toString());        
        //Datos del Ejecutor
            hash.put("nombreEje", nombreEjTextField.getText().toString());
            hash.put("codigoEje", codEjTextField.getText().toString());
            hash.put("ggEje", GGRespImpComboBox.getSelectedItem().toString());
            hash.put("gEje", GRespImpComboBox.getSelectedItem().toString());
            hash.put("extensionEje", extEjTextField.getText().toString());
    }
    
    public Window() {
        initComponents();
        reqid=1000;
        numreq=1;
        table= new Vector();
        rows= new Vector();
        board = Cartelera.getInstance();
        
        hash= new Requerimiento(Integer.toString(reqid));
        //Datos del Requerimiento
            hash.put("requestID", Integer.toString(reqid));
            hash.put("numero", Integer.toString(numreq));
            hash.put("fecha", "");
            hash.put("situacion", "");
            hash.put("ejes", "");
            hash.put("iniciativa", "");
            hash.put("certificacion", "No Certificado");
            hash.put("nombre", "Carro de Compra");
            hash.put("descripcion", "Carro de compra para la pagina web");
            hash.put("dsaa", "Proyecto");
            hash.put("aplicacion", "CRM");
            hash.put("prioridad", "Media");
            hash.put("impactoNegocio", "Medio");
            hash.put("justificacion", "Es necesario para compras electronicas");
            hash.put("fechaEsperada", "04/08/2012");
            hash.put("fechaCertificacion", "");        
        //Datos del Solicitante
            hash.put("nombreS", "Fernando De Freitas");
            hash.put("codigoS", "18390587");
            hash.put("vpS", "Mercadeo");
            hash.put("ggS", "Consumo");
            hash.put("gS", "Publicidad y Mercadeo");
        //Datos de la Persona de Contacto
            hash.put("nombreC", "Leonardo Chacon");
            hash.put("vpC", "Sistemas");
            hash.put("ggC", "Datos");
            hash.put("gC", "Desarrollos Web");
            hash.put("extensionC", "071");
            board.add(hash);
        reqid++; numreq++;
        hash= new Requerimiento(Integer.toString(reqid));
        //Datos del Requerimiento
            hash.put("requestID", Integer.toString(reqid));
            hash.put("numero", Integer.toString(numreq));
            hash.put("fecha", "");
            hash.put("situacion", "");
            hash.put("ejes", "");
            hash.put("iniciativa", "");
            hash.put("certificacion", "No Certificado");
            hash.put("nombre", "Filtrar en Oferta");
            hash.put("descripcion", "Filtro para productos en oferta");
            hash.put("dsaa", "Proyecto");
            hash.put("aplicacion", "CRM");
            hash.put("prioridad", "Media");
            hash.put("impactoNegocio", "Medio");
            hash.put("justificacion", "Es necesario para compras electronicas");
            hash.put("fechaEsperada", "04/08/2012");
            hash.put("fechaCertificacion", "");        
        //Datos del Solicitante
            hash.put("nombreS", "Jesus Ugueto");
            hash.put("codigoS", "17710650");
            hash.put("vpS", "Mercadeo");
            hash.put("ggS", "Consumo");
            hash.put("gS", "Publicidad y Mercadeo");
        //Datos de la Persona de Contacto
            hash.put("nombreC", "Leonardo Chacon");
            hash.put("vpC", "Sistemas");
            hash.put("ggC", "Datos");
            hash.put("gC", "Desarrollos Web");
            hash.put("extensionC", "071");
            board.add(hash);
        reqid++; numreq++;
        hash= new Requerimiento(Integer.toString(reqid));
        //Datos del Requerimiento
            hash.put("requestID", Integer.toString(reqid));
            hash.put("numero", Integer.toString(numreq));
            hash.put("fecha", "");
            hash.put("situacion", "");
            hash.put("ejes", "");
            hash.put("iniciativa", "");
            hash.put("certificacion", "No Certificado");
            hash.put("nombre", "Yo solo queria cachitos");
            hash.put("descripcion", "a los desarrolladores les da hambre");
            hash.put("dsaa", "Proyecto");
            hash.put("aplicacion", "CRM");
            hash.put("prioridad", "Media");
            hash.put("impactoNegocio", "Medio");
            hash.put("justificacion", "no sean agalluos");
            hash.put("fechaEsperada", "04/08/2012");
            hash.put("fechaCertificacion", "");        
        //Datos del Solicitante
            hash.put("nombreS", "Pepe");
            hash.put("codigoS", "11111111");
            hash.put("vpS", "Mercadeo");
            hash.put("ggS", "Consumo");
            hash.put("gS", "Publicidad y Mercadeo");
        //Datos de la Persona de Contacto
            hash.put("nombreC", "Leonardo Chacon");
            hash.put("vpC", "Sistemas");
            hash.put("ggC", "Datos");
            hash.put("gC", "Desarrollos Web");
            hash.put("extensionC", "071");
            board.add(hash);
        reqid++; numreq++;
        requestIDTextField.setText(Integer.toString(reqid));    //setear valores sugeridos en la interfaz
        numReqTextField.setText(Integer.toString(numreq));      //setear valores sugeridos en la interfaz
        
        fillTable();
        login= new Login(this);
        login.setVisible(true);
        this.setVisible(false);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requerimientoPanel = new javax.swing.JPanel();
        numReqLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        situacionLabel = new javax.swing.JLabel();
        numReqTextField = new javax.swing.JTextField();
        fechaTextField = new javax.swing.JTextField();
        situacionComboBox = new javax.swing.JComboBox();
        ejesLabel = new javax.swing.JLabel();
        ejesTextField = new javax.swing.JTextField();
        iniciativasLabel = new javax.swing.JLabel();
        iniciativasComboBox = new javax.swing.JComboBox();
        requestIDLabel = new javax.swing.JLabel();
        requestIDTextField = new javax.swing.JTextField();
        tabbedPane = new javax.swing.JTabbedPane();
        solicitantePanel = new javax.swing.JPanel();
        certReqLabel = new javax.swing.JLabel();
        certReqComboBox = new javax.swing.JComboBox();
        datosReqLabel = new javax.swing.JLabel();
        datosReqPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        descTextField = new javax.swing.JTextField();
        nombreReqTextField = new javax.swing.JTextField();
        DSAAComboBox = new javax.swing.JComboBox();
        aplicacionComboBox = new javax.swing.JComboBox();
        prioridadComboBox = new javax.swing.JComboBox();
        impactoComboBox = new javax.swing.JComboBox();
        obsTextField = new javax.swing.JTextField();
        fechaEspTextField = new javax.swing.JTextField();
        fechaCertTextField = new javax.swing.JTextField();
        datosSolLabel = new javax.swing.JLabel();
        datosSolPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nombreSolTextField = new javax.swing.JTextField();
        codigoSolTextField = new javax.swing.JTextField();
        VPSolComboBox = new javax.swing.JComboBox();
        GGSolComboBox = new javax.swing.JComboBox();
        GSolComboBox = new javax.swing.JComboBox();
        datosContLabel = new javax.swing.JLabel();
        datosContPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nombreContTextField = new javax.swing.JTextField();
        VPContComboBox = new javax.swing.JComboBox();
        GGContComboBox = new javax.swing.JComboBox();
        GContComboBox = new javax.swing.JComboBox();
        extTextField = new javax.swing.JTextField();
        funcionalPanel = new javax.swing.JPanel();
        datosComitePanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        statusComTIComboBox = new javax.swing.JComboBox();
        obsComTextField = new javax.swing.JTextField();
        fechaCancTextField = new javax.swing.JTextField();
        fechaPendTextField = new javax.swing.JTextField();
        gerenciaTextField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        prioridadTIComboBox = new javax.swing.JComboBox();
        fechaComTextField = new javax.swing.JTextField();
        fechaFactTextField = new javax.swing.JTextField();
        fechaReqTextField = new javax.swing.JTextField();
        datosComiteLabel = new javax.swing.JLabel();
        datosReqFuncLabel = new javax.swing.JLabel();
        datosReqFuncPanel = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        compComboBox = new javax.swing.JComboBox();
        solicitudComboBox = new javax.swing.JComboBox();
        tipoReqComboBox = new javax.swing.JComboBox();
        subtipoReqComboBox = new javax.swing.JComboBox();
        fechaEstTextField = new javax.swing.JTextField();
        datosRespFuncLabel = new javax.swing.JLabel();
        datosRespFuncPanel = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        nombreRespFuncTextField = new javax.swing.JTextField();
        codRespFuncTextField = new javax.swing.JTextField();
        GGRespFuncComboBox = new javax.swing.JComboBox();
        GRespFuncComboBox = new javax.swing.JComboBox();
        implementacionPanel = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        fechaInTextField = new javax.swing.JTextField();
        fechaEstCulmTextField = new javax.swing.JTextField();
        fechaCulmTextField = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        nombreRespImpTextField = new javax.swing.JTextField();
        codRespImpTextField = new javax.swing.JTextField();
        GGRespImpComboBox = new javax.swing.JComboBox();
        GRespImpComboBox = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        costoTextField = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        monedaComboBox = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        impactoTecComboBox = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        obsImpTextField = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        nombreEjTextField = new javax.swing.JTextField();
        codEjTextField = new javax.swing.JTextField();
        GGEjComboBox = new javax.swing.JComboBox();
        GEjComboBox = new javax.swing.JComboBox();
        extEjTextField = new javax.swing.JTextField();
        verCareleraButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requerimientoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numReqLabel.setText("Nro. Requerimiento");

        fechaLabel.setText("Fecha Solicitud");

        situacionLabel.setText("Situacion");

        situacionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ejesLabel.setText("Ejes de Telefonica");

        iniciativasLabel.setText("Iniciativas");

        iniciativasComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout requerimientoPanelLayout = new javax.swing.GroupLayout(requerimientoPanel);
        requerimientoPanel.setLayout(requerimientoPanelLayout);
        requerimientoPanelLayout.setHorizontalGroup(
            requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requerimientoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, requerimientoPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(ejesTextField))
                        .addComponent(numReqLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, requerimientoPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(numReqTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                    .addComponent(ejesLabel))
                .addGap(82, 82, 82)
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(requerimientoPanelLayout.createSequentialGroup()
                        .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaLabel)
                            .addGroup(requerimientoPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(fechaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(106, 106, 106)
                        .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(situacionLabel)
                            .addGroup(requerimientoPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(situacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(iniciativasLabel)
                    .addGroup(requerimientoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(iniciativasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        requerimientoPanelLayout.setVerticalGroup(
            requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requerimientoPanelLayout.createSequentialGroup()
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numReqLabel)
                    .addComponent(fechaLabel)
                    .addComponent(situacionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numReqTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(situacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ejesLabel)
                    .addComponent(iniciativasLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(requerimientoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ejesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciativasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        requestIDLabel.setText("RequestID:");

        certReqLabel.setText("Certificacion del Requerimiento");

        certReqComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Certificado", "No Certificado" }));

        datosReqLabel.setText("Datos del Requerimiento");

        datosReqPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        datosReqPanel.setName("Datos del Requerimiento"); // NOI18N

        jLabel9.setText("Nombre Req.");

        jLabel11.setText("Descripcion");

        jLabel12.setText("DSAA");

        jLabel13.setText("Aplicacion");

        jLabel14.setText("Prioridad Solic.");

        jLabel15.setText("Impacto Negocio");

        jLabel16.setText("Justificacion/Obs");

        jLabel17.setText("Fecha Esperada");

        jLabel18.setText("Fecha Certificacion");

        DSAAComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monitoreo", "Operacion", "Proyecto" }));

        aplicacionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CRM", "ADQUIRA", "REMEDY", "AFILIACION PARA" }));

        prioridadComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));

        impactoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bajo", "Medio", "Alto" }));

        javax.swing.GroupLayout datosReqPanelLayout = new javax.swing.GroupLayout(datosReqPanel);
        datosReqPanel.setLayout(datosReqPanelLayout);
        datosReqPanelLayout.setHorizontalGroup(
            datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosReqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datosReqPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(fechaCertTextField))
                    .addGroup(datosReqPanelLayout.createSequentialGroup()
                        .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreReqTextField)
                            .addComponent(descTextField)
                            .addComponent(fechaEspTextField)
                            .addComponent(obsTextField)
                            .addComponent(impactoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prioridadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aplicacionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DSAAComboBox, 0, 226, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosReqPanelLayout.setVerticalGroup(
            datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosReqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nombreReqTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(DSAAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(aplicacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(prioridadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(impactoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(obsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fechaEspTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fechaCertTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        datosSolLabel.setText("Datos del Solicitante");

        datosSolPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Nombre Empleado");

        jLabel21.setText("Codigo");

        jLabel22.setText("VP Solicitante");

        jLabel23.setText("GG Solicitante");

        jLabel24.setText("G Solicitante");

        VPSolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas", "RRHH", "Mercadeo" }));

        GGSolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas de Implantacion", "Datos", "Recursos", "Administracion", "Consumo", "PyMES" }));

        GSolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepago", "SAP", "Desarrollos Web", "Gestion de Cambios", "Educacion", "RRHH", "Contabilidad", "Adm", "Natural", "Adm. Comercial", "Mineria de Datos", "Publicidad y Mercadeo", "Grandes Usuarios", "Retencion y Fidelizacion" }));

        javax.swing.GroupLayout datosSolPanelLayout = new javax.swing.GroupLayout(datosSolPanel);
        datosSolPanel.setLayout(datosSolPanelLayout);
        datosSolPanelLayout.setHorizontalGroup(
            datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosSolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoSolTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(nombreSolTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(VPSolComboBox, 0, 350, Short.MAX_VALUE)
                    .addComponent(GGSolComboBox, 0, 350, Short.MAX_VALUE)
                    .addComponent(GSolComboBox, 0, 350, Short.MAX_VALUE))
                .addContainerGap())
        );
        datosSolPanelLayout.setVerticalGroup(
            datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosSolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(nombreSolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(codigoSolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(VPSolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(GGSolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosSolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(GSolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datosContLabel.setText("Datos Contacto");

        datosContPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("Nombre Contacto");

        jLabel27.setText("VP Contacto");

        jLabel28.setText("GG Conacto");

        jLabel29.setText("G Contacto");

        jLabel30.setText("Extension");

        VPContComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas", "RRHH", "Mercadeo" }));

        GGContComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas de Implantacion", "Datos", "Recursos", "Administracion", "Consumo", "PyMES" }));

        GContComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepago", "SAP", "Desarrollos Web", "Gestion de Cambios", "Educacion", "RRHH", "Contabilidad", "Adm", "Natural", "Adm. Comercial", "Mineria de Datos", "Publicidad y Mercadeo", "Grandes Usuarios", "Retencion y Fidelizacion" }));

        javax.swing.GroupLayout datosContPanelLayout = new javax.swing.GroupLayout(datosContPanel);
        datosContPanel.setLayout(datosContPanelLayout);
        datosContPanelLayout.setHorizontalGroup(
            datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosContPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(extTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(nombreContTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(VPContComboBox, 0, 352, Short.MAX_VALUE)
                    .addComponent(GGContComboBox, 0, 352, Short.MAX_VALUE)
                    .addComponent(GContComboBox, 0, 352, Short.MAX_VALUE))
                .addContainerGap())
        );
        datosContPanelLayout.setVerticalGroup(
            datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosContPanelLayout.createSequentialGroup()
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nombreContTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(VPContComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(GGContComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(GContComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosContPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(extTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout solicitantePanelLayout = new javax.swing.GroupLayout(solicitantePanel);
        solicitantePanel.setLayout(solicitantePanelLayout);
        solicitantePanelLayout.setHorizontalGroup(
            solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solicitantePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(solicitantePanelLayout.createSequentialGroup()
                        .addComponent(certReqLabel)
                        .addGap(18, 18, 18)
                        .addComponent(certReqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(solicitantePanelLayout.createSequentialGroup()
                        .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datosReqLabel)
                            .addComponent(datosReqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datosContPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datosContLabel)
                            .addComponent(datosSolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datosSolLabel))))
                .addContainerGap())
        );
        solicitantePanelLayout.setVerticalGroup(
            solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solicitantePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certReqLabel)
                    .addComponent(certReqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datosReqLabel)
                    .addComponent(datosSolLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(solicitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(solicitantePanelLayout.createSequentialGroup()
                        .addComponent(datosSolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datosContLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datosContPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(datosReqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datosReqPanel.getAccessibleContext().setAccessibleName("Datos del Requerimiento");

        tabbedPane.addTab("Informacion de Solicitante", solicitantePanel);

        datosComitePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setText("Status Comite TI");

        jLabel33.setText("Observaciones Comite TI");

        jLabel34.setText("Fecha Cancelado / NA");

        jLabel35.setText("Fecha Pend Recurso");

        jLabel36.setText("Gerencia Demanda Respuesta Func");

        statusComTIComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aprobado", "Por Certificar", "Concluido" }));

        jLabel37.setText("Prioridad TI");

        jLabel38.setText("Fecha Comite");

        jLabel39.setText("Fecha Factibilidad");

        jLabel40.setText("Fecha Req. Interv.");

        prioridadTIComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));

        javax.swing.GroupLayout datosComitePanelLayout = new javax.swing.GroupLayout(datosComitePanel);
        datosComitePanel.setLayout(datosComitePanelLayout);
        datosComitePanelLayout.setHorizontalGroup(
            datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosComitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datosComitePanelLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gerenciaTextField))
                    .addGroup(datosComitePanelLayout.createSequentialGroup()
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(59, 59, 59)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaPendTextField)
                            .addComponent(fechaCancTextField)
                            .addComponent(obsComTextField)
                            .addComponent(statusComTIComboBox, 0, 168, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addGap(26, 26, 26)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaReqTextField)
                            .addComponent(fechaFactTextField)
                            .addComponent(fechaComTextField)
                            .addComponent(prioridadTIComboBox, 0, 220, Short.MAX_VALUE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        datosComitePanelLayout.setVerticalGroup(
            datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosComitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(statusComTIComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(prioridadTIComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosComitePanelLayout.createSequentialGroup()
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(obsComTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(fechaCancTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(fechaPendTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(datosComitePanelLayout.createSequentialGroup()
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaComTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(fechaFactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(fechaReqTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosComitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(gerenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datosComiteLabel.setText("Datos Comite TI");

        datosReqFuncLabel.setText("Datos Requerimiento");

        datosReqFuncPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel42.setText("Tipo de Requerimiento");

        jLabel43.setText("Sub-Tipo");

        jLabel44.setText("Fecha Est. Inicio");

        jLabel45.setText("Complejidad");

        jLabel46.setText("Solicitud");

        compComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));

        solicitudComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Planificada", "No Planificada", "Por Revisar" }));

        tipoReqComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        subtipoReqComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout datosReqFuncPanelLayout = new javax.swing.GroupLayout(datosReqFuncPanel);
        datosReqFuncPanel.setLayout(datosReqFuncPanelLayout);
        datosReqFuncPanelLayout.setHorizontalGroup(
            datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosReqFuncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtipoReqComboBox, 0, 235, Short.MAX_VALUE)
                    .addComponent(tipoReqComboBox, 0, 235, Short.MAX_VALUE)
                    .addComponent(compComboBox, 0, 235, Short.MAX_VALUE)
                    .addComponent(solicitudComboBox, 0, 235, Short.MAX_VALUE)
                    .addComponent(fechaEstTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addContainerGap())
        );
        datosReqFuncPanelLayout.setVerticalGroup(
            datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosReqFuncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(tipoReqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(subtipoReqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(fechaEstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(compComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosReqFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(solicitudComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        datosRespFuncLabel.setText("Datos del Responsable Funcional (TI)");

        datosRespFuncPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel48.setText("Nombre Resp. Func.");

        jLabel49.setText("Codigo Resp. Func.");

        jLabel50.setText("GG Resp. Func.");

        jLabel51.setText("G Resp. Func.");

        GGRespFuncComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas de Implantacion", "Datos", "Recursos", "Administracion", "Consumo", "PyMES" }));

        GRespFuncComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepago", "SAP", "Desarrollos Web", "Gestion de Cambios", "Educacion", "RRHH", "Contabilidad", "Adm", "Natural", "Adm. Comercial", "Mineria de Datos", "Publicidad y Mercadeo", "Grandes Usuarios", "Retencion y Fidelizacion" }));

        javax.swing.GroupLayout datosRespFuncPanelLayout = new javax.swing.GroupLayout(datosRespFuncPanel);
        datosRespFuncPanel.setLayout(datosRespFuncPanelLayout);
        datosRespFuncPanelLayout.setHorizontalGroup(
            datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosRespFuncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GRespFuncComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GGRespFuncComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codRespFuncTextField)
                    .addComponent(nombreRespFuncTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        datosRespFuncPanelLayout.setVerticalGroup(
            datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosRespFuncPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(nombreRespFuncTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(codRespFuncTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(GGRespFuncComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosRespFuncPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(GRespFuncComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout funcionalPanelLayout = new javax.swing.GroupLayout(funcionalPanel);
        funcionalPanel.setLayout(funcionalPanelLayout);
        funcionalPanelLayout.setHorizontalGroup(
            funcionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcionalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funcionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosComitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datosComiteLabel)
                    .addGroup(funcionalPanelLayout.createSequentialGroup()
                        .addComponent(datosReqFuncLabel)
                        .addGap(296, 296, 296)
                        .addComponent(datosRespFuncLabel))
                    .addGroup(funcionalPanelLayout.createSequentialGroup()
                        .addComponent(datosReqFuncPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datosRespFuncPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        funcionalPanelLayout.setVerticalGroup(
            funcionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funcionalPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(datosComiteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datosComitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funcionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datosReqFuncLabel)
                    .addComponent(datosRespFuncLabel))
                .addGap(12, 12, 12)
                .addGroup(funcionalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datosReqFuncPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datosRespFuncPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Informacion Funcional", funcionalPanel);

        jLabel52.setText("Fechas Requerimiento");

        jLabel53.setText("Datos del Responsable Implementacion/Ejecucion");

        jLabel54.setText("Datos del Requerimiento");

        jLabel55.setText("Datos del Ejecutor");

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel56.setText("Fecha Inicio Real");

        jLabel57.setText("Fecha Est. Culminacion");

        jLabel58.setText("Fecha Culminacion");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaCulmTextField)
                    .addComponent(fechaEstCulmTextField)
                    .addComponent(fechaInTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(fechaInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(fechaEstCulmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(fechaCulmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel59.setText("Nombre Resp. Impl.");

        jLabel60.setText("Cod. Resp. Impl.");

        jLabel61.setText("GG Resp. Impl.");

        jLabel62.setText("G Resp. Impl.");

        GGRespImpComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas de Implantacion", "Datos", "Recursos", "Administracion", "Consumo", "PyMES" }));

        GRespImpComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepago", "SAP", "Desarrollos Web", "Gestion de Cambios", "Educacion", "RRHH", "Contabilidad", "Adm", "Natural", "Adm. Comercial", "Mineria de Datos", "Publicidad y Mercadeo", "Grandes Usuarios", "Retencion y Fidelizacion" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GRespImpComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GGRespImpComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codRespImpTextField)
                    .addComponent(nombreRespImpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(nombreRespImpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(codRespImpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(GGRespImpComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(GRespImpComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel63.setText("Costo");

        jLabel64.setText("Bs/$");

        monedaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bs", "$" }));

        jLabel65.setText("Impacto Tecnico");

        impactoTecComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alto", "Medio", "Bajo" }));

        jLabel66.setText("Observaciones");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(costoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(monedaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(obsImpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(impactoTecComboBox, 0, 276, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(costoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(monedaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(impactoTecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(obsImpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel67.setText("Nombre Ejecutor");

        jLabel68.setText("Codigo Ejecutor");

        jLabel69.setText("GG Ejecutor");

        jLabel70.setText("G Ejecutor");

        jLabel71.setText("Extension");

        GGEjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sistemas de Implantacion", "Datos", "Recursos", "Administracion", "Consumo", "PyMES" }));

        GEjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepago", "SAP", "Desarrollos Web", "Gestion de Cambios", "Educacion", "RRHH", "Contabilidad", "Adm", "Natural", "Adm. Comercial", "Mineria de Datos", "Publicidad y Mercadeo", "Grandes Usuarios", "Retencion y Fidelizacion" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addGap(32, 32, 32)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(extEjTextField)
                    .addComponent(GEjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GGEjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codEjTextField)
                    .addComponent(nombreEjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(nombreEjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(codEjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(GGEjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(GEjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(extEjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout implementacionPanelLayout = new javax.swing.GroupLayout(implementacionPanel);
        implementacionPanel.setLayout(implementacionPanelLayout);
        implementacionPanelLayout.setHorizontalGroup(
            implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(implementacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel55)
                        .addComponent(jLabel53)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        implementacionPanelLayout.setVerticalGroup(
            implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, implementacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(implementacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab("Informacion Implementacion/Ejecucion", implementacionPanel);

        verCareleraButton.setText("Ver Cartelera");
        verCareleraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCareleraButtonActionPerformed(evt);
            }
        });

        guardarButton.setText("Guardar");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                    .addComponent(requerimientoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(requestIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 546, Short.MAX_VALUE)
                        .addComponent(logoutButton)
                        .addGap(18, 18, 18)
                        .addComponent(verCareleraButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarButton)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(requestIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestIDLabel)
                    .addComponent(verCareleraButton)
                    .addComponent(guardarButton)
                    .addComponent(logoutButton))
                .addGap(2, 2, 2)
                .addComponent(requestIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requerimientoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
    login.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_logoutButtonActionPerformed

private void verCareleraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCareleraButtonActionPerformed
// TODO add your handling code here:
    fillTable();
    busq= new Busqueda(this);
    busq.setVisible(true);
}//GEN-LAST:event_verCareleraButtonActionPerformed

//<editor-fold defaultstate="collapsed" desc="Inicializacion de Java">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Window().setVisible(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DSAAComboBox;
    private javax.swing.JComboBox GContComboBox;
    private javax.swing.JComboBox GEjComboBox;
    private javax.swing.JComboBox GGContComboBox;
    private javax.swing.JComboBox GGEjComboBox;
    private javax.swing.JComboBox GGRespFuncComboBox;
    private javax.swing.JComboBox GGRespImpComboBox;
    private javax.swing.JComboBox GGSolComboBox;
    private javax.swing.JComboBox GRespFuncComboBox;
    private javax.swing.JComboBox GRespImpComboBox;
    private javax.swing.JComboBox GSolComboBox;
    private javax.swing.JComboBox VPContComboBox;
    private javax.swing.JComboBox VPSolComboBox;
    private javax.swing.JComboBox aplicacionComboBox;
    private javax.swing.JComboBox certReqComboBox;
    private javax.swing.JLabel certReqLabel;
    private javax.swing.JTextField codEjTextField;
    private javax.swing.JTextField codRespFuncTextField;
    private javax.swing.JTextField codRespImpTextField;
    private javax.swing.JTextField codigoSolTextField;
    private javax.swing.JComboBox compComboBox;
    private javax.swing.JTextField costoTextField;
    private javax.swing.JLabel datosComiteLabel;
    private javax.swing.JPanel datosComitePanel;
    private javax.swing.JLabel datosContLabel;
    private javax.swing.JPanel datosContPanel;
    private javax.swing.JLabel datosReqFuncLabel;
    private javax.swing.JPanel datosReqFuncPanel;
    private javax.swing.JLabel datosReqLabel;
    private javax.swing.JPanel datosReqPanel;
    private javax.swing.JLabel datosRespFuncLabel;
    private javax.swing.JPanel datosRespFuncPanel;
    private javax.swing.JLabel datosSolLabel;
    private javax.swing.JPanel datosSolPanel;
    private javax.swing.JTextField descTextField;
    private javax.swing.JLabel ejesLabel;
    private javax.swing.JTextField ejesTextField;
    private javax.swing.JTextField extEjTextField;
    private javax.swing.JTextField extTextField;
    private javax.swing.JTextField fechaCancTextField;
    private javax.swing.JTextField fechaCertTextField;
    private javax.swing.JTextField fechaComTextField;
    private javax.swing.JTextField fechaCulmTextField;
    private javax.swing.JTextField fechaEspTextField;
    private javax.swing.JTextField fechaEstCulmTextField;
    private javax.swing.JTextField fechaEstTextField;
    private javax.swing.JTextField fechaFactTextField;
    private javax.swing.JTextField fechaInTextField;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JTextField fechaPendTextField;
    private javax.swing.JTextField fechaReqTextField;
    private javax.swing.JTextField fechaTextField;
    private javax.swing.JPanel funcionalPanel;
    private javax.swing.JTextField gerenciaTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JComboBox impactoComboBox;
    private javax.swing.JComboBox impactoTecComboBox;
    private javax.swing.JPanel implementacionPanel;
    private javax.swing.JComboBox iniciativasComboBox;
    private javax.swing.JLabel iniciativasLabel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JButton logoutButton;
    private javax.swing.JComboBox monedaComboBox;
    private javax.swing.JTextField nombreContTextField;
    private javax.swing.JTextField nombreEjTextField;
    private javax.swing.JTextField nombreReqTextField;
    private javax.swing.JTextField nombreRespFuncTextField;
    private javax.swing.JTextField nombreRespImpTextField;
    private javax.swing.JTextField nombreSolTextField;
    private javax.swing.JLabel numReqLabel;
    private javax.swing.JTextField numReqTextField;
    private javax.swing.JTextField obsComTextField;
    private javax.swing.JTextField obsImpTextField;
    private javax.swing.JTextField obsTextField;
    private javax.swing.JComboBox prioridadComboBox;
    private javax.swing.JComboBox prioridadTIComboBox;
    private javax.swing.JPanel requerimientoPanel;
    private javax.swing.JLabel requestIDLabel;
    private javax.swing.JTextField requestIDTextField;
    private javax.swing.JComboBox situacionComboBox;
    private javax.swing.JLabel situacionLabel;
    private javax.swing.JPanel solicitantePanel;
    private javax.swing.JComboBox solicitudComboBox;
    private javax.swing.JComboBox statusComTIComboBox;
    private javax.swing.JComboBox subtipoReqComboBox;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JComboBox tipoReqComboBox;
    private javax.swing.JButton verCareleraButton;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
	public void changeTabs(int who){
    	switch (who) {
		case 1:
			solicitantePanel.setEnabled(true);
			funcionalPanel.setEnabled(false);
			implementacionPanel.setEnabled(false);
			break;
		
		case 2:
			funcionalPanel.setEnabled(true);
			implementacionPanel.setEnabled(false);
			solicitantePanel.setEnabled(false);
			break;
			
		case 3:
			funcionalPanel.setEnabled(false);
			implementacionPanel.setEnabled(true);
			solicitantePanel.setEnabled(false);
			break;
			
		default:
			break;
		}
    }

	public int getSesion() {
		return sesion;
	}

	public void setSesion(int sesion) {
		this.sesion = sesion;
	}
	
	
}
