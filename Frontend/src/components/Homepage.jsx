import axios from 'axios';
import Button from '@mui/material/Button'
import Typography from '@mui/material/Typography'
import Card from '@mui/material/Card'
import CardContent from '@mui/material/CardContent'
import { CardMedia,CardActions, Box } from '@mui/material'

export const Homepage = () => {
    const handlePortalLogin = async () => {
        const response = await axios.get('http://localhost:8080/portal-login?user_email=727722euit126@skcet.ac.in&user_password=P@vi$2005')
        console.log(response);
    }
    const handleWifiLogin = async () => {
        const response = await axios.get('http://localhost:8080/wifi-login?username=22IT123&&password=pavi1441')
        console.log(response);
    }

  return ( 
    <>
      <Typography variant="h3" style={{ fontWeight: 'bold', marginBottom: '30px',paddingBottom: '6vh' }}>SKCET utility tools</Typography>
      <Box sx={{display: 'flex', justifyContent: 'space-around', width: '94vw'}}>

      <Card sx={{ maxWidth: 345, textAlign: 'initial' }}>
        <CardMedia
          sx={{ height: 210 }}
          image="/images/wifi-log.png"
          title="Wifi"
          component='img'
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            WIFI Login
          </Typography>
          <Typography variant="body1" color="text.secondary">
            This tool will help you to login with our Iamneo or any other lab wifi. Give a try!
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={handleWifiLogin}>Login</Button>
          <Button size="small">Learn More</Button>
        </CardActions>
      </Card>

      <Card sx={{ maxWidth: 345, textAlign: 'initial' }}>
        <CardMedia
          sx={{ height: 210 }}
          title="Wifi"
          component='img'
          image="/images/Institution-Logo (1).png"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Portal Login
          </Typography>
          <Typography variant="body1" color="text.secondary">
            By clicking Login button, you can able to login to our Institution Web Portal.
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={handlePortalLogin}>Login</Button>
          <Button size="small">Learn More</Button>
        </CardActions>
      </Card>
      </Box>
    </>
  )
}
