
import { createBrowserRouter } from "react-router-dom";
import { Home } from "../pages/Public/index";
import { CentroDeInovacao } from "../pages/Public/CentroDeInovacao";
import { DetalhesCentroDeInovacao } from "../pages/Public/CentroDeInovacao/DetalhesCentroDeInovacao";
import { AdminHome } from "../pages/Admin";
import { ParquesCientificos } from "../pages/Public/ParquesCientificos";
import { DetalhesParquesCientificos } from "../pages/Public/ParquesCientificos/DetalhesParquesCientificos";
import { DetalhesCoworkings } from "../pages/Public/Coworkings/DetalhesCoworkings";
import { Coworkings } from "../pages/Public/Coworkings";
import { EditCentroDeInovacaoAdmin } from "../pages/Admin/CentroDeInovacaoAdmin/EditCentroDeInovacao";
import { CentroDeInovacaoAdmin } from "../pages/Admin/CentroDeInovacaoAdmin";
import { AdicionarCentroDeInovacaoAdmin } from "../pages/Admin/CentroDeInovacaoAdmin/AdicionarCentroDeInovacao";
import { ProtectedRoute } from "./ProtectedRoute";
import { ParqueCientificoAdmin } from "../pages/Admin/ParqueCientificoAdmin";
import { AdicionarParqueCientificoAdmin } from "../pages/Admin/ParqueCientificoAdmin/AdicionarParqueCientifico";
import { EditParqueCientificoAdmin } from "../pages/Admin/ParqueCientificoAdmin/EditParqueCientifico";
import { CoworkingAdmin } from "../pages/Admin/CoworkingAdmin";
import { AdicionarCoworkingAdmin } from "../pages/Admin/CoworkingAdmin/AdicionarCoworking";
import { EditCoworkingAdmin } from "../pages/Admin/CoworkingAdmin/EditCoworking";


const router = createBrowserRouter([
    {
      path: "/",
      element:  <Home></Home>,
    },
    {
      path: '/centros-de-inovacao',
      element: <CentroDeInovacao></CentroDeInovacao>,
    },
    {
      path: '/coworkings',
      element: <Coworkings></Coworkings>,
    },
    {
      path: '/detalhes-coworking/:id',
      element: <DetalhesCoworkings></DetalhesCoworkings>,
    },
    {
      path: '/parques-cientificos',
      element: <ParquesCientificos></ParquesCientificos>,
    },
    {
      path: '/detalhes-parque-cientifico/:id',
      element: <DetalhesParquesCientificos></DetalhesParquesCientificos>,
    },
    {
      path: "/detalhes-centro-de-inovacao/:id",
      element: <DetalhesCentroDeInovacao></DetalhesCentroDeInovacao>,
    },
    {
      path: "/admin",
      element: <ProtectedRoute><AdminHome></AdminHome></ProtectedRoute>,
    },
    {
      path: "/centros-de-inovacao-admin",
      element: <ProtectedRoute><CentroDeInovacaoAdmin></CentroDeInovacaoAdmin></ProtectedRoute>,
    },
    {
      path: "/coworkings-admin",
      element: <ProtectedRoute><CoworkingAdmin></CoworkingAdmin></ProtectedRoute>,
    },
    {
      path: "/coworkings-admin/adicionar",
      element: <ProtectedRoute><AdicionarCoworkingAdmin></AdicionarCoworkingAdmin></ProtectedRoute>,
    },
    {
      path: "/coworkings-admin/:id",
      element: <ProtectedRoute><EditCoworkingAdmin></EditCoworkingAdmin></ProtectedRoute>,
    },
    {
      path: "/centros-de-inovacao-admin/:id",
      element: <ProtectedRoute><EditCentroDeInovacaoAdmin></EditCentroDeInovacaoAdmin></ProtectedRoute>,
    },
    {
      path: "/centros-de-inovacao-admin/adicionar",
      element: <ProtectedRoute><AdicionarCentroDeInovacaoAdmin></AdicionarCentroDeInovacaoAdmin></ProtectedRoute>,
    },
    {
      path: "/parques-cientificos-admin",
      element: <ProtectedRoute><ParqueCientificoAdmin></ParqueCientificoAdmin></ProtectedRoute>,
    },
    {
      path: "/parques-cientificos-admin/adicionar",
      element: <ProtectedRoute><AdicionarParqueCientificoAdmin></AdicionarParqueCientificoAdmin></ProtectedRoute>,
    },
    {
      path: "/parques-cientificos-admin/:id",
      element: <ProtectedRoute><EditParqueCientificoAdmin></EditParqueCientificoAdmin></ProtectedRoute>,
    },
    {
        path: "*",
        element: <Home></Home>,
    }
    
]);

export default router;